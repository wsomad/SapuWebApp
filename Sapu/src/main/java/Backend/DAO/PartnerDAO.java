package Backend.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Backend.Interface.BaseCRUD;
import Backend.Model.PartnerModel;
import Backend.Model.VehicleModel;
import Backend.Service.DatabaseInit;

public class PartnerDAO implements BaseCRUD<PartnerModel> {
	private Connection connection;
	private UserDAO userDAO;
	private VehicleDAO vehicleDAO;
	
	public PartnerDAO() {
		try {
			this.connection = DatabaseInit.getConnection();
			this.userDAO = new UserDAO();
			this.vehicleDAO = new VehicleDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(PartnerModel partner) {
		try {
			connection.setAutoCommit(false);
			
			if (!userDAO.create(partner)) {
				connection.rollback();
				return false;
			}
			
			String sql = "INSERT INTO PARTNER ("
			 		+ "UID, "
			 		+ "rating,"
			 		+ "payment"
			 		+ "VALUES (?, ?, ?)";
			try(PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, partner.getUID());
				statement.setDouble(2, partner.getRating());
				statement.setString(3, partner.getPayment());
				int rowsInserted = statement.executeUpdate();
				
				if (rowsInserted > 0) {
					for (VehicleModel vehicle : partner.getVehicleList()) {
						vehicle.setUID(partner.getUID());
						boolean isVehicleCreated = vehicleDAO.create(vehicle);
						if (isVehicleCreated == false) {
							connection.rollback();
							return false;
						}
					}
					connection.commit();
					return true;
				}
				else {
					connection.rollback();
					return false;
				}
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
                connection.setAutoCommit(true);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
		}
		return false;
	}

	@Override
	public PartnerModel read(String UID) {
		PartnerModel partner = (PartnerModel) userDAO.read(UID);
		if (partner == null) {
			return null;
		}
		
		String sql = "SELECT * FROM PARTNER WHERE UID = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, UID);
			try(ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					return readResultSet(result);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PartnerModel> readAll() {
		List<PartnerModel> partnerList = new ArrayList<>();
		String sql = "SELECT * FROM PARTNER";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				partnerList.add(readResultSet(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partnerList;
	}

	@Override
	public boolean update(PartnerModel partner) {
		try {
			connection.setAutoCommit(false);
			
			if (!userDAO.update(partner)) {
				connection.rollback();
				return false;
			}
			
			String sql = "UPDATE PARTNER SET"
					+ "rating = ?,"
					+ "payment = ?,"
					+ "WHERE UID = ?";
			try(PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setDouble(1, partner.getRating());
				statement.setString(2, partner.getPayment());
				statement.setString(3, partner.getUID());
				int rowsUpdated = statement.executeUpdate();
				
				if (rowsUpdated > 0) {
					for (VehicleModel vehicle : partner.getVehicleList()) {
						vehicle.setUID(partner.getUID());
						if (!vehicleDAO.update(vehicle)) {
							connection.rollback();
							return false;
						}
					}
					connection.commit();
					return true;
				}
				else {
					connection.rollback();
					return false;
				}
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public boolean delete(String UID) {
	    try {
	        connection.setAutoCommit(false); // Begin transaction

	        // Delete from VEHICLE table
	        if (!vehicleDAO.deleteByOwnerUID(UID)) {
	            connection.rollback(); // Rollback transaction if vehicle deletion fails
	            return false;
	        }

	        // Delete from PARTNER table
	        String sql = "DELETE FROM PARTNER WHERE UID = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, UID);
	            int rowsDeleted = statement.executeUpdate();

	            if (rowsDeleted > 0) {
	                // Delete from USER table
	                if (userDAO.delete(UID)) {
	                    connection.commit(); // Commit transaction if all deletions are successful
	                    return true;
	                } else {
	                    connection.rollback(); // Rollback transaction if user deletion fails
	                    return false;
	                }
	            } else {
	                connection.rollback(); // Rollback transaction if partner deletion fails
	                return false;
	            }
	        }
	    } catch (SQLException e) {
	        try {
	            connection.rollback(); // Rollback transaction on error
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            connection.setAutoCommit(true); // Reset auto-commit to true
	        } catch (SQLException autoCommitEx) {
	            autoCommitEx.printStackTrace();
	        }
	    }
	}
	
	private PartnerModel readResultSet(ResultSet result) throws SQLException {
		PartnerModel partner = new PartnerModel();
		partner.setRating(result.getDouble("rating"));
		partner.setPayment(result.getString("payment"));
		partner.setVehicleList(new ArrayList<VehicleModel>());
		return partner;
	}
}

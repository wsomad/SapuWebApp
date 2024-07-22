package Backend.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

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
						if (!vehicleDAO.create(vehicle)) {
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
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean update(PartnerModel model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

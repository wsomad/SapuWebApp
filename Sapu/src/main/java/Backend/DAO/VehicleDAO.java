package Backend.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Backend.Interface.BaseCRUD;
import Backend.Model.VehicleModel;
import Backend.Service.DatabaseInit;

public class VehicleDAO implements BaseCRUD<VehicleModel> {
	private Connection connection;
	
	public VehicleDAO() {
		try {
			this.connection = DatabaseInit.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(VehicleModel vehicle) {
	    String sql = "INSERT INTO VEHICLE ("
	    		+ "vehicleID"
	            + "brand, "
	            + "bodyStyle, "
	            + "model, "
	            + "numberOfSeater, "
	            + "color, "
	            + "yearManufactured, "
	            + "plateNumber, "
	            + "fuel, "
	            + "transmission, "
	            + "chasisNumber, "
	            + "engineNumber, "
	            + "images, "
	            + "insuranceName, "
	            + "insuranceType, "
	            + "insuranceExpiryDate"
	            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	    	statement.setString(1, vehicle.getVehicleID());
	        statement.setString(2, vehicle.getBrand());
	        statement.setString(3, vehicle.getBodyStyle());
	        statement.setString(4, vehicle.getModel());
	        statement.setInt(5, vehicle.getNumberOfSeater());
	        statement.setString(6, vehicle.getColor());
	        statement.setString(7, vehicle.getYearManufactured());
	        statement.setString(8, vehicle.getPlateNumber());
	        statement.setString(9, vehicle.getFuel());
	        statement.setString(10, vehicle.getTransmission());
	        statement.setString(11, vehicle.getChasisNumber());
	        statement.setString(12, vehicle.getEngineNumber());
	        statement.setInt(13, vehicle.getImages());
	        statement.setString(14, vehicle.getInsuranceName());
	        statement.setString(15, vehicle.getInsuranceType());
	        statement.setString(16, vehicle.getInsuranceExpiryDate());
	        int rowsInserted = statement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public VehicleModel read(String vehicleID) {
		String sql = "SELECT * FROM VEHICLE WHERE vehicleID = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, vehicleID);
			try(ResultSet resultset = statement.executeQuery()) {
				if (resultset.next()) {
					return readResultSet(resultset);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<VehicleModel> readAll() {
		List<VehicleModel> vehicleList = new ArrayList<>();
		String sql = "SELECT * FROM VEHICLE";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				vehicleList.add(readResultSet(result));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

	@Override
	public boolean update(VehicleModel vehicle) {
		String sql = "UPDATE VEHICLE SET"
	            + "brand = ?,"
	            + "bodyStyle = ?,"
	            + "model = ?, "
	            + "numberOfSeater = ?,"
	            + "color = ?, "
	            + "yearManufactured = ?,"
	            + "plateNumber = ?,"
	            + "fuel = ?,"
	            + "transmission = ?,"
	            + "chasisNumber = ?,"
	            + "engineNumber = ?,"
	            + "images = ?,"
	            + "insuranceName = ?,"
	            + "insuranceType = ?,"
	            + "insuranceExpiryDate = ?,"
	            + "WHERE vehicleID = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, vehicle.getBrand());
	        statement.setString(2, vehicle.getBodyStyle());
	        statement.setString(3, vehicle.getModel());
	        statement.setInt(4, vehicle.getNumberOfSeater());
	        statement.setString(5, vehicle.getColor());
	        statement.setString(6, vehicle.getYearManufactured());
	        statement.setString(7, vehicle.getPlateNumber());
	        statement.setString(8, vehicle.getFuel());
	        statement.setString(9, vehicle.getTransmission());
	        statement.setString(10, vehicle.getChasisNumber());
	        statement.setString(11, vehicle.getEngineNumber());
	        statement.setInt(12, vehicle.getImages());
	        statement.setString(13, vehicle.getInsuranceName());
	        statement.setString(14, vehicle.getInsuranceType());
	        statement.setString(15, vehicle.getInsuranceExpiryDate());
			statement.setString(16, vehicle.getVehicleID());
	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String vehicleID) {
		String sql = "DELETE FROM VEHICLE WHERE vehicleID = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehicleID);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
	}
	
	public boolean deleteByOwnerUID(String UID) {
		String sql = "DELETE FROM VEHICLE WHERE UID = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, UID);
			int rowsDeleted = statement.executeUpdate();
			return rowsDeleted > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private VehicleModel readResultSet(ResultSet result) throws SQLException {
		VehicleModel vehicleModel = new VehicleModel();
		vehicleModel.setVehicleID(result.getString("VehicleID"));
		vehicleModel.setBrand(result.getString("Brand"));
		vehicleModel.setBodyStyle(result.getString("BodyStyle"));
		vehicleModel.setModel(result.getString("Model"));
		vehicleModel.setNumberOfSeater(result.getInt("NumberOfSeater"));
		vehicleModel.setColor(result.getString("Color"));
		vehicleModel.setYearManufactured(result.getString("YearManufactured"));
		vehicleModel.setPlateNumber(result.getString("PlateNumber"));
		vehicleModel.setFuel(result.getString("Fuel"));
		vehicleModel.setTransmission(result.getString("Transmission"));
		vehicleModel.setChasisNumber(result.getString("ChasisNumber"));
		vehicleModel.setEngineNumber(result.getString("EngineNumber"));
		vehicleModel.setImages(result.getInt("Images"));
		vehicleModel.setInsuranceName(result.getString("InsuranceName"));
		vehicleModel.setInsuranceType(result.getString("InsuranceType"));
		vehicleModel.setInsuranceExpiryDate(result.getString("InsuranceExpiryDate"));
		return vehicleModel;
	}
}

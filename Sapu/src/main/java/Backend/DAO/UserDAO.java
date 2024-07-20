package Backend.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Backend.Interface.BaseCRUD;
import Backend.Model.UserModel;
import Backend.Service.DatabaseService;

public class UserDAO implements BaseCRUD<UserModel> {
	private Connection connection;
	
	public UserDAO() {
		try {
			this.connection = DatabaseService.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(UserModel user) {
		String sql = "INSERT INTO USER ("
				+ "email, "
				+ "password, "
				+ "username, "
				+ "phoneNumber, "
				+ "walletBalance"
				+ ") VALUES (?, ?, ?, ?)";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, user.getEmail());
			statement.setString(1, user.getPassword());
			statement.setString(1, user.getUsername());
			statement.setString(1, user.getPhoneNumber());
			statement.setDouble(1, user.getWalletBalance());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public UserModel read(String UID) {
		String sql = "SELECT * FROM USER WHERE UID =" + UID;
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, UID);
			try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return getUserFromResultSet(resultSet);
                }
            }
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	public UserModel readByUsername(String username) {
		String sql = "SELECT * FROM USER WHERE username = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, username);
			try(ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					return getUserFromResultSet(result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserModel> readAll() {
		List<UserModel> userList = new ArrayList<>();
		String sql = "SELECT * FROM USER";
		try(PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery()) {
			while (result.next()) {
				userList.add(getUserFromResultSet(result));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(UserModel user) {
		String sql = "UPDATE USER SET email = ?, "
				+ "password = ?, "
				+ "username = ?, "
				+ "phoneNumber = ?, "
				+ "walletBalance = ?"
				+ "WHERE UID = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPhoneNumber());
			statement.setDouble(5, user.getWalletBalance());
			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(String UID) {
		String sql = "DELETE FROM USER WHERE UID = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, UID);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
	}
	
	private UserModel getUserFromResultSet(ResultSet result) throws SQLException {
		UserModel user = new UserModel();
		user.setUID(result.getString("UID"));
		user.setEmail(result.getString("email"));
		user.setPassword(result.getString("password"));
		user.setUsername(result.getString("username"));
		user.setPhoneNumber(result.getString("phoneNumber"));
		user.setWalletBalance(result.getDouble("walletBalance"));
		return user;
	}
	
}

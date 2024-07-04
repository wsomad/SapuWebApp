package Backend.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Backend.Interface.UserInterface;
import Backend.Model.UserModel;
import Backend.Service.DatabaseService;

public class UserDAO implements UserInterface {
	private Connection connection;
	
	public UserDAO() {
		try {
			this.connection = DatabaseService.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean createUser(UserModel user) {
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
	public UserModel getUserByUID(String UID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

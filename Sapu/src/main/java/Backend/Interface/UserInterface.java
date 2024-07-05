package Backend.Interface;

import java.util.List;

import Backend.Model.UserModel;

public interface UserInterface {
	boolean createUser(UserModel user);
	UserModel getUserByUID(String UID);
	UserModel getUserByUsername(String username);
	List<UserModel> getAllUsers();
	boolean updateUser(UserModel user);
	boolean deleteUser(String UID);
}

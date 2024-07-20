package Backend.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInit {
	private static final String URL = "jdbc:mysql://localhost:3306/sapu";
	private static final String username = "root";
	private static final String password = "root123";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, username, password);
	}
	
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

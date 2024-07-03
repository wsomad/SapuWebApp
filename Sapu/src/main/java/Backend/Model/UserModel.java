package Backend.Model;

public class UserModel {
	private String UID;
	private String email;
	private String password;
	private String username;
	private String phoneNumber;
	private double walletBalance;
	private static int counter = 1;
	
	public UserModel() {
		setUID(generateUserID());
		setEmail("");
		setPassword("");
		setUsername("");
		setPhoneNumber("");
		setWalletBalance(0.00);
	}
	
	public UserModel(String email, String password, String username, String phoneNumber, double walletBalance) {
		this.UID = UID != null ? UID : generateUserID();
		this.email = email;
		this.password = password;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.walletBalance = Math.round(walletBalance * 100.0) / 100.0;
	}
	
	private synchronized String generateUserID() {
        return String.format("u%06d", counter++);
    }
	
	public void setUID(String UID) {
		this.UID = UID;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	public String getUID() {
		return UID;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public double getWalletBalance() {
		return walletBalance;
	}
	
}

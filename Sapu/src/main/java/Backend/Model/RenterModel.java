package Backend.Model;

import java.util.List;

public class RenterModel extends UserModel {
	private DriverLicenseModel driverLicense;
	private List<RentalHistoryModel> rentalHistory; 
	
	public RenterModel(String email, String password, String username, String phoneNumber, double walletBalance, DriverLicenseModel driverLicense, List<RentalHistoryModel> rentalHistory) {
        super(email, password, username, phoneNumber, walletBalance);
        this.driverLicense = driverLicense;
        this.rentalHistory = rentalHistory;
    }
	
	public DriverLicenseModel getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicenseModel driverLicense) {
        this.driverLicense = driverLicense;
    }

    public List<RentalHistoryModel> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(List<RentalHistoryModel> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public void addRental(RentalHistoryModel rentalHistory) {
        this.rentalHistory.add(rentalHistory);
    }
}

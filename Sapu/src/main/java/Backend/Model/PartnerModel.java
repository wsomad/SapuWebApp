package Backend.Model;

import java.util.List;

public class PartnerModel extends UserModel {
	private List<VehicleModel> vehicleList;
	private double rating;
	private String payment;
	
	public PartnerModel(String email, String password, String username, String phoneNumber, double walletBalance, List<VehicleModel> vehicleList, double rating, String payment) {
        super(email, password, username, phoneNumber, walletBalance);
        this.vehicleList = vehicleList;
        this.rating = rating;
        this.payment = payment;
    }

    public PartnerModel() {
	}

	// Getters and setters
    public List<VehicleModel> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<VehicleModel> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}

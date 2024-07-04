package Backend.Model;

import java.util.Date;

public class RentalHistoryModel {
	private String rentalID;
	private VehicleModel vehicle;
	private Date startDate;
	private Date endDate;
	private boolean availability;
	private double rentalRate;
	private String location;
	private String rentalType;
	private String status;
	private PaymentModel payment;
	private static int counter = 1;
	
	public RentalHistoryModel(VehicleModel vehicle, Date startDate, Date endDate,
			double rentalRate, String status) {
		super();
		this.rentalID = generateRentalID();
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentalRate = rentalRate;
		this.status = status;
	}
	
	public RentalHistoryModel(String rentalID, VehicleModel vehicle, Date startDate, Date endDate, boolean availability,
			double rentalRate, String location, String rentalType, String status) {
		super();
		this.rentalID = generateRentalID();
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.availability = availability;
		this.rentalRate = rentalRate;
		this.location = location;
		this.rentalType = rentalType;
		this.status = status;
	}
	
	private synchronized String generateRentalID() {
		return String.format("r%06d", counter++);
	}
	
	public String getRentalID() {
		return rentalID;
	}
	public void setRentalID(String rentalID) {
		this.rentalID = rentalID;
	}
	
	public VehicleModel getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleModel vehicle) {
		this.vehicle = vehicle;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		if (location.equals("Gopeng")) {
			this.location = "Gopeng";
		}
		else if (location.equals("Kampar")) {
			this.location = "Kampar";
		}
		else if (location.equals("Tapah")) {
			this.location = "Tapah";
		}
		else if (location.equals("Bidor")) {
			this.location = "Bidor";
		}
		else {
			this.location = "Ipoh";
		}
	}
	
	public String getRentalType() {
		return rentalType;
	}

	public void setRentalType(String rentalType) {
		if (rentalType.equals("Partner")) {
			this.rentalType = "Partner";
		}
		else {
			this.rentalType = "Company";
		}
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public PaymentModel getPayment() {
		return payment;
	}
	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}
}

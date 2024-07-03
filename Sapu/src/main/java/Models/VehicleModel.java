package Models;

public class VehicleModel {
	private String vehicleID;
	private String brand;
	private String bodyStyle;
	private String model;
	private int numberOfSeater;
	private String color;
	private String yearManufactured;
	private String plateNumber;
	private String fuel;
	private String transmission;
	private String chasisNumber;
	private String engineNumber;
	private int images;
	private String insuranceName;
	private String insuranceType;
	private String insuranceExpiryDate;
	private boolean availability;
	private double rentalRate;
	private String location;
	private String rentalType;
	private static int counter = 1;
	
	public VehicleModel() {
		super();
		setVehicleID(vehicleID);
	}
	
	public VehicleModel(String vehicleID, String brand, String bodyStyle, String model, int numberOfSeater,
			String color, String yearManufactured, String plateNumber, String fuel, String transmission,
			String chasisNumber, String engineNumber, int images, String insuranceName, String insuranceType,
			String insuranceExpiryDate, boolean availability, double rentalRate, String location, String rentalType) {
		super();
		this.vehicleID = vehicleID;
		this.brand = brand;
		this.bodyStyle = bodyStyle;
		this.model = model;
		this.numberOfSeater = numberOfSeater;
		this.color = color;
		this.yearManufactured = yearManufactured;
		this.plateNumber = plateNumber;
		this.fuel = fuel;
		this.transmission = transmission;
		this.chasisNumber = chasisNumber;
		this.engineNumber = engineNumber;
		this.images = images;
		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.insuranceExpiryDate = insuranceExpiryDate;
		this.availability = availability;
		this.rentalRate = rentalRate;
		this.location = location;
		this.rentalType = rentalType;
	}

	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBodyStyle() {
		return bodyStyle;
	}
	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getNumberOfSeater() {
		return numberOfSeater;
	}
	public void setNumberOfSeater(int numberOfSeater) {
		this.numberOfSeater = numberOfSeater;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getYearManufactured() {
		return yearManufactured;
	}
	public void setYearManufactured(String yearManufactured) {
		this.yearManufactured = yearManufactured;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		if (fuel.equals("Petrol")) {
			this.fuel = "Petrol";
		}
		else {
			this.fuel = "Diesel";
		}
	}
	
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		if (transmission.equals("Automatic")) {
			this.transmission = "Automatic";
		}
		else {
			this.transmission = "Manual";
		}	
	}
	
	public String getChasisNumber() {
		return chasisNumber;
	}
	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}
	
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	
	public int getImages() {
		return images;
	}
	public void setImages(int images) {
		this.images = images;
	}
	
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		if (insuranceType.equals("First Party")) {
			this.insuranceType = "First Party";
		}
		else {
			this.insuranceType = "Third Party";
		}
	}
	
	public String getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}
	public void setInsuranceExpiryDate(String insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
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
}

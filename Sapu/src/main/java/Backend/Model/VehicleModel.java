package Backend.Model;

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
	private static int counter = 1;
	
	public VehicleModel() {
		super();
		setVehicleID(vehicleID);
	}
	
	public VehicleModel(String brand, String model, String yearManufactured, String bodyStyle) {
		super();
		this.brand = brand;
		this.bodyStyle = bodyStyle;
		this.model = model;
		this.yearManufactured = yearManufactured;
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
}

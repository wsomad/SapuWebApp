package Backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Backend.Model.DriverLicenseModel;
import Backend.Model.PartnerModel;
import Backend.Model.RentalHistoryModel;
import Backend.Model.RenterModel;
import Backend.Model.VehicleModel;

public class Main {
    public static void main(String[] args) {
        // Creating a DriverLicense object
        DriverLicenseModel driverLicense = new DriverLicenseModel("DL123456", new Date(), null, "Pending", new Date());

        // Creating a Rental object (assuming you have a Car class defined)
        VehicleModel vehicle = new VehicleModel("Toyota", "Camry", "2021", "Sedan");
        RentalHistoryModel rental = new RentalHistoryModel("rental001", vehicle, new Date(), new Date(System.currentTimeMillis() + 86400000), 100.0, "Active");

        // Creating a RenterModel object
        RenterModel renter = new RenterModel("renter@example.com", "password123", "John", "012345678", 100.00, driverLicense, new ArrayList<>());
        renter.addRental(rental);

        // Creating a PartnerModel object
        List<VehicleModel> carsList = new ArrayList<>();
        PartnerModel partner = new PartnerModel("partner@example.com", "password456", "Karen", "012345678", 200.00, carsList, 4.5, "bankInfo");

        // Printing the details
        System.out.println("Renter UID: " + renter.getUID());
        System.out.println("Renter UID: " + renter.getUsername());
        System.out.println("Partner UID: " + partner.getUID());
        System.out.println("Partner UID: " + partner.getUsername());
    }
}
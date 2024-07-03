package Backend.Model;

import java.util.Date;

public class DriverLicenseModel {
	private String licenseNumber;
	private Date expirationDate;
	private byte[] licenseFile;
	private String status;
	private Date dateUploaded;
	
	public DriverLicenseModel(String licenseNumber, Date expirationDate, byte[] licenseFile, String status, Date dateUploaded) {
        this.licenseNumber = licenseNumber;
        this.expirationDate = expirationDate;
        this.licenseFile = licenseFile;
        this.status = status;
        this.dateUploaded = dateUploaded;
    }
	
	public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public byte[] getLicenseFile() {
        return licenseFile;
    }
    public void setLicenseFile(byte[] licenseFile) {
        this.licenseFile = licenseFile;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }
    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }
}

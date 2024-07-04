package Backend.Model;

public class PaymentModel {
	private String paymentID;
	private String method;
	private String currency;
	private String status;
	
	public PaymentModel(String paymentID, String method, String currency, String status) {
		super();
		this.paymentID = paymentID;
		this.method = method;
		this.currency = currency;
		this.status = status;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

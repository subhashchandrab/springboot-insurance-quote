package com.oci.acme.model.quote;

public class QuoteParameters {
	private String vehicleNumber;
	private int mobileNumber;
	private boolean previousPolicyExpired;
	private boolean isComprehensive;
	private int registrationYear;
	private int productType;

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public boolean isPreviousPolicyExpired() {
		return previousPolicyExpired;
	}

	public void setPreviousPolicyExpired(boolean previousPolicyExpired) {
		this.previousPolicyExpired = previousPolicyExpired;
	}

	public boolean isComprehensive() {
		return isComprehensive;
	}

	public void setComprehensive(boolean isComprehensive) {
		this.isComprehensive = isComprehensive;
	}

	public int getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(int registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}

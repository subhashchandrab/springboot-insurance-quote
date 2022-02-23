package com.oci.acme.model.quote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsuranceQuote {
	
	private Date expiryDate;
	
	private double	premium;
	
	private String planDetails;
	
	private int validityInYears;
	
	private PlanType planType;

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
		this.planDetails = planType.name();
		this.setValidityInYears(planType.getValidityInYears());
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, planType.getValidityInYears());
        Date expiryDate = c.getTime();
		this.setExpiryDate(expiryDate);		
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public String getExpiryDateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(expiryDate);
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public String getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}

	public int getValidityInYears() {
		return validityInYears;
	}

	public void setValidityInYears(int tenure) {
		this.validityInYears = tenure;
	}
	

}

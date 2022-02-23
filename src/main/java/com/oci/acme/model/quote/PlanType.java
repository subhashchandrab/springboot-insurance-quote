package com.oci.acme.model.quote;

public enum PlanType {
	STANDARD(1),
	BUDGET(2),
	MEGASAVER(3);
	
	private int validityInYears;
	
	private PlanType(int validityInYears) {
		this.validityInYears = validityInYears;
	}
	
	public int getValidityInYears() {
		return this.validityInYears;
	}
}

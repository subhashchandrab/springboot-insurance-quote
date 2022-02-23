package com.oci.acme.model;

public class InsuranceProduct {
	
	private int id;

	private String type;
	
	
	public InsuranceProduct(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public String getType() {
		return type;
	}

}

package com.oci.acme.model.quote;

import java.util.Arrays;
import java.util.List;

public class QuoteInputData {
	
	private List<String> carBrandNames = Arrays.asList(new String[] {"Hyundai", "Maruti", "TATA", "Ford", "Kia", "Volkswagen"});
	private List<String> registrationCityNames = Arrays.asList(new String[] {"Bengaluru", "Hyderabad", "Chennai", "Delhi", "Kolkata", "Mumbai"});
	public List<String> getCarBrandNames() {
		return carBrandNames;
	}
	public List<String> getRegistrationCityNames() {
		return registrationCityNames;
	}

}

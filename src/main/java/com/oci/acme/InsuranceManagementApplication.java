package com.oci.acme;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oci.acme.model.InsuranceProduct;
import com.oci.acme.model.quote.InsuranceQuote;
import com.oci.acme.model.quote.QuoteInputData;
import com.oci.acme.model.quote.QuoteParameters;
import com.oci.acme.service.QuoteService;

@SpringBootApplication(scanBasePackages = { "com.oci.acme" })
@RestController
@RequestMapping(value = "/acme/")
public class InsuranceManagementApplication {


	@Autowired
	QuoteService quoteService;
	
	public static void main(String[] args) {

		SpringApplication.run(InsuranceManagementApplication.class, args);
	}


	@CrossOrigin
	@GetMapping("/getInsuranceProducts")
	public List<InsuranceProduct> getInsuranceProducts() {
		InsuranceProduct carInsurance = new InsuranceProduct(100, "Car Insurance");
		InsuranceProduct bikeInsurance = new InsuranceProduct(200, "Bike Insurance");
		InsuranceProduct healthInsurance = new InsuranceProduct(300, "Health Insurance");
		InsuranceProduct travelInsurance = new InsuranceProduct(400, "Travel Insurance");
		InsuranceProduct homeInsurance = new InsuranceProduct(500, "Home Insurance");
		List<InsuranceProduct> insuranceProducts = new ArrayList<InsuranceProduct>();
		insuranceProducts.add(carInsurance);
		insuranceProducts.add(bikeInsurance);
		insuranceProducts.add(healthInsurance);
		insuranceProducts.add(travelInsurance);
		insuranceProducts.add(homeInsurance);
		return insuranceProducts;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/getInsuranceQuotes")
	public List<InsuranceQuote> getQuotes(@RequestBody QuoteParameters quoteParams) {
		return quoteService.getQuotes(quoteParams);
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/getQuoteInputData")
	public QuoteInputData getQuoteInputData() {
		return quoteService.getQuoteInputData();
	}	
	
}
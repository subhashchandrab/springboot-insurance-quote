package com.oci.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oci.acme.model.quote.InsuranceQuote;
import com.oci.acme.model.quote.PlanType;
import com.oci.acme.model.quote.QuoteInputData;
import com.oci.acme.model.quote.QuoteParameters;

@Service
public class QuoteService {
	
	private static final double TRAVEL_BASIC_PREMIUM = 1575.0;
	private static final double HOME_ANNUAL_BASIC_PREMIUM = 9800.0;
	private static final double CAR_ANNUAL_BASIC_PREMIUM = 8540.0;
	private static final QuoteInputData QUOTE_INPUT_DATA = new QuoteInputData();

	public List<InsuranceQuote> getQuotes(QuoteParameters quoteParams) {
		List<InsuranceQuote> quotesList = new ArrayList<InsuranceQuote>();
		double basicPremium = getAnnualBasePremium(quoteParams.getProductType());
		for(PlanType planType : PlanType.values()) {
			quotesList.add(getQuote(planType, basicPremium, quoteParams ));
		}
		return quotesList;
	}
	
	private InsuranceQuote getQuote(PlanType planType, double basicPremium, QuoteParameters quoteParams) {
		InsuranceQuote quote = new InsuranceQuote();
		quote.setPlanType(planType);
		int validityInYears = planType.getValidityInYears();
		double discountPercent = validityInYears * 0.05;
		double totalPremium = (basicPremium * validityInYears) - (basicPremium * discountPercent);

		double previousPolicyExpirationCharge = quoteParams.isPreviousPolicyExpired() ? 200 : 0;
		double comprehensivePolicyCharge = quoteParams.isComprehensive() ? totalPremium * 0.25 : 0;
		totalPremium = totalPremium + previousPolicyExpirationCharge + comprehensivePolicyCharge;
		quote.setPremium(totalPremium);
        
		return quote;
	}
	
	public QuoteInputData getQuoteInputData() {
		return QUOTE_INPUT_DATA;
	}
	
	public double getAnnualBasePremium(int productType) {
		
		switch(productType) {
		case 1:
			return CAR_ANNUAL_BASIC_PREMIUM;
		case 2:
			return HOME_ANNUAL_BASIC_PREMIUM;
		case 3:
			return TRAVEL_BASIC_PREMIUM;
		default:
			return 0;
		}
	}
	
}

package com.demo.model;

import java.util.Map;

public class IpDataModel {

	private String country;
	private String isoCode;
	private String baseCurrency;
	private Map<String, Double> rates;
	
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getIsoCode() {
		return isoCode;
	}
	
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "IpDataModel [country=" + country + ", isoCode=" + isoCode + ", baseCurrency=" + baseCurrency
				+ ", rates=" + rates + "]";
	}


}

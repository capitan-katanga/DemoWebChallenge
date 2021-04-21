package com.demo.model.ip2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ip2CountryModel {
	private String countryCode3;
	private String countryName;
	
	public String getCountryCode3() {
		return countryCode3;
	}
	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public String toString() {
		return "CountryCode [countryCode3=" + countryCode3 + ", countryName=" + countryName + "]";
	}
	
	
	

}

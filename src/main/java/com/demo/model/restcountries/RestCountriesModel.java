package com.demo.model.restcountries;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestCountriesModel {
	
	private Currencies[] currencies;

	public Currencies[] getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Currencies[] currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "RestCountriesModel [currencies=" + Arrays.toString(currencies) + "]";
	}
	
	
	
	

}

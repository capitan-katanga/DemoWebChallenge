package com.demo.model.restcountries;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestCountriesModel {
	
	private List<Currencies> currencies;
	
	public RestCountriesModel(List<Currencies> currencies) {
		this.currencies = currencies;
	}
	
	public RestCountriesModel() {
	}

	public List<Currencies> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currencies> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "RestCountriesModel [currencies=" + currencies + "]";
	}
	

}

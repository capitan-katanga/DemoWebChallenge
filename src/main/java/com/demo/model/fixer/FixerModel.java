package com.demo.model.fixer;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixerModel {
	private String date;
	private String base;
	private Map<String, Double> rates;
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "FixerModel [date=" + date + ", base=" + base + ", rates=" + rates + "]";
	}

	
}

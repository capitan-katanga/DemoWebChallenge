package com.demo.model.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currencies {
	private String code;
	private String name;
	
	public Currencies() {
	}

	public Currencies(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Currencies [code=" + code + ", name=" + name + "]";
	}

}

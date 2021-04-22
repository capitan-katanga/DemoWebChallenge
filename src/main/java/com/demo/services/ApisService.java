package com.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.demo.model.fixer.FixerModel;
import com.demo.model.ip2.Ip2CountryModel;
import com.demo.model.restcountries.RestCountriesModel;

@Service
public class ApisService {

	private static final Logger log = LoggerFactory.getLogger(ApisService.class);

	@Autowired
	private RestTemplate restTemplate;

	public Ip2CountryModel getIp2Country(String ipAddress) {

		final String urlIp2Country = "https://api.ip2country.info/ip?";

		try {

			ResponseEntity<Ip2CountryModel> response = restTemplate.getForEntity(urlIp2Country + ipAddress,
					Ip2CountryModel.class);

			log.info(response.toString());

			Ip2CountryModel ip2 = response.getBody();

			return ip2;

		} catch (HttpStatusCodeException e) {
			throw e;
		}
	}

	public RestCountriesModel getRestCountries(String countryCode3) {

		final String urlRestCountries = "https://restcountries.eu/rest/v2/alpha/";

		try {

			ResponseEntity<RestCountriesModel> response = restTemplate.getForEntity(urlRestCountries + countryCode3,
					RestCountriesModel.class);

			log.info(response.toString());

			RestCountriesModel restCo = response.getBody();

			return restCo;
		} catch (HttpStatusCodeException e) {
			throw e;
		}
	}

	public FixerModel getFixer(String symbols) {

		final String urlFixer = "http://data.fixer.io/api/latest?access_key=";
		final String key = "64b3c0c6417c6f48ec09cac9d638eb50";
		final String params = "&base=eur&symbols=";

		try {
			ResponseEntity<FixerModel> response = restTemplate.getForEntity(urlFixer + key + params + symbols,
					FixerModel.class);

			log.info(response.toString());

			FixerModel fix = response.getBody();

			return fix;
		} catch (HttpStatusCodeException e) {
			throw e;
		}

	}

}

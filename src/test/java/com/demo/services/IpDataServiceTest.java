package com.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.restcountries.Currencies;
import com.demo.model.restcountries.RestCountriesModel;

@SpringBootTest
public class IpDataServiceTest {

	@Autowired
	private IpDataService ipDataService;

	@Test
	public void currencyNullTest() {
		String expected = "";
		String result = ipDataService.getSymbolsFromRestCountries(null);

		assertEquals(result, expected);

	}

	@Test
	public void currenciesStringTest() {
		String expected = "ars,zwe,cny";

		Currencies curr1 = new Currencies("ars");
		Currencies curr2 = new Currencies("zwe");
		Currencies curr3 = new Currencies("cny");

		RestCountriesModel resCo = new RestCountriesModel(Arrays.asList(curr1, curr2, curr3));

		String result = ipDataService.getSymbolsFromRestCountries(resCo);

		assertEquals(result, expected);

	}

}

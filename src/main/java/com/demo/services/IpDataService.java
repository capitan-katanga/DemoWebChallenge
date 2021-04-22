package com.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.BlackList;
import com.demo.model.IpDataModel;
import com.demo.model.fixer.FixerModel;
import com.demo.model.ip2.Ip2CountryModel;
import com.demo.model.restcountries.RestCountriesModel;
import com.demo.repository.BlackListRepo;

@Service
public class IpDataService {

	// private static final Logger log = LoggerFactory.getLogger(ApisService.class);

	@Autowired
	private ApisService apisService;

	@Autowired
	private BlackListRepo blrepo;

	public IpDataModel getIpData(String ipAddress) {
		IpDataModel infoIp = new IpDataModel();

		Ip2CountryModel ip2 = apisService.getIp2Country(ipAddress);
		RestCountriesModel resCo = apisService.getRestCountries(ip2.getCountryCode3());
		FixerModel fix = apisService.getFixer(getSymbolsFromRestCountries(resCo));

		infoIp.setCountry(ip2.getCountryName());
		infoIp.setIsoCode(ip2.getCountryCode3());
		infoIp.setBaseCurrency(fix.getBase());
		infoIp.setRates(fix.getRates());

		return infoIp;

	}

	public String getSymbolsFromRestCountries(RestCountriesModel resCo) {

		String symbols = "";

		if (resCo != null)
			symbols = resCo.getCurrencies().stream().map((c) -> c.getCode()).collect(Collectors.joining(","));

		return symbols;
	}

	public boolean ipInBlackList(String ipAddress) {
		List<BlackList> listBlackList = blrepo.findAll();

		return listBlackList.stream().filter((black) -> black.getIpAddress().equals(ipAddress)).findAny().isPresent();

		/*
		 * for (BlackList bl : listBlackList) { if (bl.getIpAddress().equals(ipAddress))
		 * { log.info("La ip: " + ipAddress.toString() +
		 * " se encuentra en al lista negra"); return true; } } log.info("La ip: " +
		 * ipAddress.toString() + " no se encuentra en al lista negra"); return false;
		 */
	}

}

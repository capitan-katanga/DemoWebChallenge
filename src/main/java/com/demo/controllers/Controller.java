package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.IpDataModel;
import com.demo.services.IpDataService;

@RestController
@RequestMapping(path = "/demo")
public class Controller {
	
	@Autowired
	private IpDataService ipDataService;
	
	@GetMapping(path="getDataIp/{IpAddress}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody IpDataModel getInfoIp(@PathVariable("IpAddress") String ipAddress) {
		if(!ipDataService.ipInBlackList(ipAddress)) {
			IpDataModel infoIp = ipDataService.getIpData(ipAddress);
			return infoIp;
		}
			
		return null;
		
	}
	
	
	

}

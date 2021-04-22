package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.IpDataModel;
import com.demo.services.IpDataService;

@RestController
@RequestMapping(path = "/demo")
public class Controller {

	@Autowired
	private IpDataService ipDataService;

	@GetMapping(path = "getDataIp/{IpAddress}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<IpDataModel> getInfoIp(@PathVariable("IpAddress") String ipAddress) {
		if (!ipDataService.ipInBlackList(ipAddress)) {
			return ResponseEntity.status(HttpStatus.OK).body(ipDataService.getIpData(ipAddress));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new IpDataModel());

	}

}

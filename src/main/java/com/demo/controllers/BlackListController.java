package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.BlackList;
import com.demo.repository.BlackListRepo;

@RestController
@RequestMapping(path = "/demo")
public class BlackListController {

	@Autowired
	private BlackListRepo blrepo;

	@GetMapping(path = "/blacklist")
	public ResponseEntity<List<BlackList>> getAllBlackList() {
		return ResponseEntity.status(HttpStatus.OK).body(blrepo.findAll());
	}

	@PostMapping(path = "/addBlacklist")
	public ResponseEntity<BlackList> saveBlackList(@RequestBody BlackList blackList) {
		return ResponseEntity.status(HttpStatus.CREATED).body(blrepo.save(blackList));
	}

}

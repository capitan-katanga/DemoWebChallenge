package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.BlackList;
import com.demo.repository.BlackListRepo;

@RestController
@RequestMapping(path = "/demo")
public class BlackListController {

	@Autowired
	private BlackListRepo blrepo;

	@GetMapping(path = "/blacklist")
	public @ResponseBody List<BlackList> getAllBlackList() {
		return blrepo.findAll();
	}

	@PostMapping(path = "/addBlacklist")
	public BlackList saveBlackList(@RequestBody BlackList blackList) {
		return blrepo.save(blackList);
	}

}

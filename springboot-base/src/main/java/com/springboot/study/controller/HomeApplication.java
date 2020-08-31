package com.springboot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.config.ServerSetting;

@RestController
public class HomeApplication {

	@GetMapping("/")
	String home() {
		return "Hello World!";
	}

	@Autowired
	public ServerSetting serverSetting;

	@GetMapping("/api/env")
	public Map<String, String> testMap() {
		Map<String, String> map = new HashMap<>();
		map.put("title", serverSetting.getTitle());
		map.put("domain", serverSetting.getDomain());
		map.put("env", serverSetting.getEnv());
		return map;
	}
}

package com.springboot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:post、delete、put方式
 * @author: chenjun
 * @date: 2020年6月28日 下午2:36:42
 */
@RestController
public class OtherController {
	private Map<String, Object> params = new HashMap<String, Object>();

	@PostMapping("/api/login")
	public Object login(String name, String password) {
		params.clear();
		params.put("name", name);
		params.put("password", password);
		return params;
	}

	@PutMapping("/api/put")
	public Object put(String name) {
		params.clear();
		params.put("name", name);
		return params;
	}

	@DeleteMapping("/api/delete")
	public Object delete(String name) {
		params.clear();
		params.put("name", name);
		return params;
	}
}

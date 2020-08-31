package com.springboot.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.study.config.ServerSetting;

/**
 * @description: thymeleaf模板
 * @author: chenjun
 * @date: 2020年6月29日 上午11:18:57
 */
@Controller
public class ThymeleafController {
	@Autowired
	public ServerSetting serverSetting;
	@RequestMapping(value = "/index")
	public Object index() {
		return "index";
	}

	@GetMapping("test")
	public String test(ModelMap modelMap) {
		modelMap.addAttribute("setting",serverSetting);
		return "test";
	}
}

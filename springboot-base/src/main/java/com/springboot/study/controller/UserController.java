package com.springboot.study.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.entity.User;
import com.springboot.study.mapper.UserMapper;
import com.springboot.study.service.UserService;
import com.springboot.study.utils.JsonData;

/**
 * @description: user controller 增删改查
 * @author: chenjun
 * @date: 2020年6月29日 下午2:47:30
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserMapper userMapper;

	@GetMapping("add")
	public Object add() throws ParseException {
		User user = new User();
		user.setName("James");
		user.setAge(34);
		user.setCountry("USA");
		user.setWork("篮球运球员");
		user.setWeight(100);
		user.setHeight(203);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1984-10-21"));
		String str = Arrays.toString(new String[] { "打篮球" });
		user.setHobbies(str.substring(1, str.length() - 1));
		userService.add(user);
		return JsonData.buildSuccess(user, "success");
	}

	@GetMapping("findById")
	public Object findById(@RequestParam(required = true) int id) {
		return JsonData.buildSuccess(userService.findById(id), "success");
	}

	@GetMapping("findAll")
	public Object getAll() {
		return JsonData.buildSuccess(userService.getAll(), "success");
	}

	@GetMapping("update")
	public Object update(@RequestParam(required = true) int id, String name) {
		User user = new User();
		user.setName(name);
		user.setId(id);
		userService.update(user);
		return JsonData.buildSuccess();
	}

	@GetMapping("delete")
	public Object delete(@RequestParam(required = true) int id) {
		userService.delete(id);
		return JsonData.buildSuccess();
	}

	@RequestMapping("/getUserWithAccount/{id}")
	public JsonData getUserWithAccount(@PathVariable("id") int id) {
		User user = userService.getUserWithAccount(id); 
		if (user != null) {
			return JsonData.buildSuccess(user, "success");
		}
		return JsonData.buildError("暂无数据", 0);
	}

	@RequestMapping("/getUserWithCompany/{id}")
	public JsonData getUserWithCompany(@PathVariable("id") int id) {
		User user = userService.getUserWithCompany(id);
		return JsonData.buildSuccess(user, "success");
	}
	@RequestMapping("/getUserInfo")
	public JsonData getUserInfo() {
		List<User> list = userService.getUserInfo();
		return JsonData.buildSuccess(list, "success");
	}
}

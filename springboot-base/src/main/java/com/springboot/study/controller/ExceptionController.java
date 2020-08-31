package com.springboot.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.entity.User;

 
/**    
 * @Description: 异常 
 * @author: chenjun
 * @date: 2020年6月28日 下午2:35:02    
 */
@RestController
public class ExceptionController {

	@RequestMapping(value = "/api/testException")
	public Object testException() {
		int i = 1 / 0;
		User user = new User();
		user.setName("Lucy");
		user.setPassword("a1234567");
		user.setTelphone("13480689632");
		user.setAge(20);
		return user;
	}

	@RequestMapping(value = "/api/testMyException")
	public Object testMyException() {
		throw new MyException(503, "自定义异常");
	}
	
}

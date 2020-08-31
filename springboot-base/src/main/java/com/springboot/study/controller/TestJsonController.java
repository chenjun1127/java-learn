package com.springboot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.entity.User;

 
/**    
 * @Description: 返回json
 * @author: chenjun
 * @date: 2020年6月28日 下午2:38:04    
 */
@RestController
public class TestJsonController {
	private Map<String, Object> params = new HashMap<String, Object>();
	
	/**   
	 * @Description: user传一个object,可以为{age:20}
	 * @param: @param user
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@RequestMapping(path = "/api/createUser")
	public Object createUser(@RequestBody User user) {
		User eric = new User();
		eric.setName("eric");
		eric.setPassword("a1234567");
		eric.setTelphone("13898623254");
		eric.setAge(30); 
		params.clear();
		params.put("data", eric);
		return params;
	}

}

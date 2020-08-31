package com.springboot.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.entity.User;

 
 
/**    
 * @description: TODO
 * @author: chenjun
 * @date: 2020年6月28日 下午3:06:46    
 */
@RestController
public class GetController {
	private Map<String, Object> params = new HashMap<String, Object>();
	 
	/**   
	 * @Description: 从路径中获取字段
	 * @param: @param userId
	 * @param: @param name
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@RequestMapping(path = "/api/{userId}/{name}", method = RequestMethod.GET)
	public Object findUser(@PathVariable String userId, @PathVariable String name) {
		params.clear();
		params.put("userId", userId);
		params.put("name", name);
		return params;
	}
	 
	/**   
	 * @Description: 获取url参数,api/getUsers?from=1&size=10
	 * @param: @param from
	 * @param: @param size
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@GetMapping(path = "/api/getUser/1")
	public Object getUser(int from, int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		return params;
	}
	   
	/**    
	 * @Description: 获取url参数 ,默认值，及参数是否必传 ,defaultValue=>默认值，name=>别名，required=>是否必要参数  
	 * @param: @param from
	 * @param: @param size
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@GetMapping(path = "/api/getUser/2")
	public Object getUserDefault(@RequestParam(defaultValue = "0", name = "page", required = true) int from, @RequestParam(defaultValue = "10") int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		return params;
	}	
	 
	/**    
	 * @Description: bean對象传参，注意Http请求头content-type为application/json;
	 * @param: @param user
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@RequestMapping(path="/api/saveUser")
	public Object saveUser(@RequestBody User user) {
		params.clear();
		params.put("user",user);
		return params;
	}
	 
	/**   
	 * @Description: 获取 http header
	 * @param: @param accessToken
	 * @param: @param id
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@GetMapping(path = "/api/getHeader")
	public Object getHeader(@RequestHeader("accessToken") String accessToken,int id) {
		params.clear();
		params.put("id",id);
		params.put("accessToken",accessToken);
		return params;
	}
	 
	/**   
	 * @Description: HttpServletRequest 获取参数
	 * @param: @param request
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@GetMapping(path = "/api/testRequest")
	public Object testRequest(HttpServletRequest request) {
		params.clear();
		params.put("id",request.getParameter("id"));
		return params;
	}
	
	@GetMapping(path = "/api/testIntecpter")
	public Object testIntecpter(HttpServletRequest request) {
		System.out.println(request);
		params.clear();
		params.put("msg","测试拦截器"); 
		return params;
	}
}

package com.springboot.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:exception
 * @author: chenjun
 * @date: 2020年6月28日 下午2:24:31
 */
@RestControllerAdvice
public class CustomExceptionHandler {
	 
	/**   
	 * @Description: 捕获全局异常
	 * @param: @param e
	 * @param: @param request
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	@ExceptionHandler(value = Exception.class)
	public Object exceptionHandler(Exception e, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("url", request.getRequestURI());
		map.put("code", 400);
		map.put("desc", e.getMessage());
		return map;
	}

	 
	/**   
	 * @Description: 自定义异常1，返回json数据
	 * @param: @param e
	 * @param: @param request
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
//	@ExceptionHandler(value = MyException.class)
//	public Object exceptionMyHandler(MyException e, HttpServletRequest request) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("url", request.getRequestURI());
//		map.put("code", e.getCode());
//		map.put("desc", e.getMsg());
//		return map;
//	}

	 
	/**   
	 * @Description: 自定义异常二，返回错误页面
	 * @param: @param e
	 * @param: @param request
	 * @param: @return      
	 * @return: ModelAndView      
	 * @throws   
	 */
	@ExceptionHandler(value = MyException.class)
	public ModelAndView exceptionMyHandlerToError(MyException e, HttpServletRequest request) {
		ModelAndView moAndView = new ModelAndView();
		moAndView.setViewName("404.html");
		moAndView.addObject("msg", e.getMsg());
		return moAndView;
	}
}

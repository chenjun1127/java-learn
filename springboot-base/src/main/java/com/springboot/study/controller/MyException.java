package com.springboot.study.controller;

/**
 * @Description: 自定义异常类
 * @author: chenjun
 * @date: 2020年6月28日 下午2:36:23
 */
public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MyException(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}

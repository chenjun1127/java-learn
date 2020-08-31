package com.example.mybaties.utils;

import java.io.Serializable;

/**
 * @Description: json返回类
 * @author: chenjun
 * @date: 2020年7月10日 下午4:22:12
 */
public class JsonData implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code; // 0 成功 -1 失败
	private Object data;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getmsg() {
		return msg;
	}

	public void setmsg(String msg) {
		this.msg = msg;
	}

	public JsonData(int code, Object data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	// 成功，只返回成功状态码
	public static JsonData buildSuccess() {
		return new JsonData(0, null, null);
	}

	// 成功，传入状态码和数据
	public static JsonData buildSuccess(Object data) {
		return new JsonData(0, data, null);
	}

	// 成功，传入数据,及描述信息
	public static JsonData buildSuccess(Object data, String msg) {
		return new JsonData(0, data, msg);
	}

	// 成功，传入数据,及状态码
	public static JsonData buildSuccess(Object data, int code) {
		return new JsonData(code, data, null);
	}

	// 失败，传入描述信息
	public static JsonData buildError(String msg) {
		return new JsonData(-1, null, msg);
	}

	// 失败，传入描述信息,状态码
	public static JsonData buildError(String msg, Integer code) {
		return new JsonData(code, null, msg);
	}
}

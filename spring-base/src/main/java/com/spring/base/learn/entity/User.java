package com.spring.base.learn.entity;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月21日 下午4:49:27
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

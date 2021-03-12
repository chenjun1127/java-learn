package com.spring.base.entities;

import org.springframework.stereotype.Component;

/**
 * @Description: 默认bean名字为类的小写
 * @Author: chenjun
 * @Date: 2020年7月22日 上午11:44:21
 */
@Component
public class Account {
	private int id;
	private String name;
	private int userId;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", name='" + name + '\'' +
				", userId=" + userId +
				'}';
	}
}

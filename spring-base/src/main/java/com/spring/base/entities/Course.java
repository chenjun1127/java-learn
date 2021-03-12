package com.spring.base.entities;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: chenjun
 * @Date: 2020年7月21日 下午4:51:23
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String summary;
	private User user;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", title='" + title + '\'' +
				", summary='" + summary + '\'' +
				", user=" + user +
				'}';
	}
}

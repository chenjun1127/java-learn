package com.spring.base.entities;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: chenjun
 * @Date: 2020年7月21日 下午6:17:36
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Car car;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Student() {
	}

	public Student(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", car=" + car +
				'}';
	}
}

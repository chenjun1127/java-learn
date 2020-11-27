package com.spring.base.learn.entity;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月21日 下午6:17:36
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Car car;

	public Student() {

	}

	public Student(Car car) {
		this.car = car;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}

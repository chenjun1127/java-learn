package com.spring.base.entities;

/**
 * @Description: TODO
 * @Author: chenjun
 * @Date: 2020年7月22日 上午10:25:25
 */
public class Car {
	private int id;
	private String name;
	private String color;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", color=" + color + "]";
	}

}

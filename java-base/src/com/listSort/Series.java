package com.listSort;

public class Series {
	public String id;
	public String name;
	public Float price;

	public Series(String id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "->" + this.name;
	}
}

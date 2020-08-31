package com.base;

public class Initail {
	public static void main(String[] args) {
		Triangle T = new Triangle(5, 10, 8, 10);
		T.calcArea();
		T.calcPerimeter();
		Rectangle R = new Rectangle(10, 20);
		R.calcArea();
		R.calcPerimeter();
	}
}

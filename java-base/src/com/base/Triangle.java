package com.base;

/**
 * @author chenjun 2020年6月12日 上午10:04:31 三角形周长面积
 */
public class Triangle extends Shape {
	public int a;
	public int b;
	public int c;
	public int h;
	public double C;
	public double A;

	public Triangle(int a, int b, int c, int h) {
		this.a = a;
		this.b = b;
		this.C = c;
		this.h = h;
	}

	@Override
	public void calcPerimeter() {
		this.c = a + b + c;
		System.out.println("三角形的周长为：" + this.C);
	}

	@Override
	public void calcArea() {
		this.A = a * h * 0.5;
		System.out.println("三角形的面积为：" + this.C);
	}

}

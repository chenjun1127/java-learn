package com.base;

/**
 * @author chenjun 2020年6月12日 上午9:58:58 计算矩形周长面积
 */
public class Rectangle extends Shape {
	public int x;
	public int y;
	public int C;
	public int A;

	public Rectangle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void calcPerimeter() {
		this.C = (this.x + this.y) * 2;
		System.out.println("矩形的周长为：" + this.C);
	}

	@Override
	public void calcArea() {
		this.A = this.x * this.y;
		System.out.println("矩形的面积为：" + this.A);

	}

}

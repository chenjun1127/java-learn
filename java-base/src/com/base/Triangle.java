package com.base;

/**
 * @author chenjun 2020��6��12�� ����10:04:31 �������ܳ����
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
		System.out.println("�����ε��ܳ�Ϊ��" + this.C);
	}

	@Override
	public void calcArea() {
		this.A = a * h * 0.5;
		System.out.println("�����ε����Ϊ��" + this.C);
	}

}

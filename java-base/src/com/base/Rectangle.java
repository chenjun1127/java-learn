package com.base;

/**
 * @author chenjun 2020��6��12�� ����9:58:58 ��������ܳ����
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
		System.out.println("���ε��ܳ�Ϊ��" + this.C);
	}

	@Override
	public void calcArea() {
		this.A = this.x * this.y;
		System.out.println("���ε����Ϊ��" + this.A);

	}

}

package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Initial {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("请输入第一个数");
			int one = input.nextInt();
			System.out.println("请输入第二个数");
			int two = input.nextInt();
			System.out.println("两个数相除的结果为：" + one / two);
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.print("你应该输入整数");

		} catch (ArithmeticException e) {
			System.out.print("除数不能为0");
		} catch (Exception e) {
			System.out.print("未知异常");
		}
	}
}

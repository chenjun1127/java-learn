package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Initail {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("�������һ����");
			int one = input.nextInt();
			System.out.println("������ڶ�����");
			int two = input.nextInt();
			System.out.println("����������Ľ��Ϊ��" + one / two);
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.print("��Ӧ����������");

		} catch (ArithmeticException e) {
			System.out.print("��������Ϊ0");
		} catch (Exception e) {
			System.out.print("δ֪�쳣");
		}
	}
}

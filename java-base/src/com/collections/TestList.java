package com.collections;

public class TestList {
	public static void main(String[] args) {
		InitList l = new InitList();
		l.addCourse();
		System.out.println("������ǰ�γ̣�");
		l.printCourse();
		System.out.println("����ĳ���γ̣�");
		l.updateCourse(3, new Course("4", "JAVA�������"));
		l.printCourse();
		System.out.println("ɾ��ĳ���γ̣�");
		l.deleteCourse("2");
		l.printCourse();
	}
}

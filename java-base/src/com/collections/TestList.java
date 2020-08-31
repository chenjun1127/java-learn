package com.collections;

public class TestList {
	public static void main(String[] args) {
		InitList l = new InitList();
		l.addCourse();
		System.out.println("遍历当前课程：");
		l.printCourse();
		System.out.println("更新某个课程：");
		l.updateCourse(3, new Course("4", "JAVA程序设计"));
		l.printCourse();
		System.out.println("删除某个课程：");
		l.deleteCourse("2");
		l.printCourse();
	}
}

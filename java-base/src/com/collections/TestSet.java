package com.collections;

import java.util.Scanner;

public class TestSet {
	public static void main(String[] args) {
		InitSet is = new InitSet();
		is.addCourse();
		is.printCourse();
		Student st = new Student("1", "jack");
		System.out.println("欢迎你，" + st.name + "，请选课！");
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("请输入课程ID");
			String courseId = input.next();
			for (Course cr : is.courseList) {
				if (courseId.equals(cr.id)) {
					st.courses.add(cr);
				}
			}
		}
		for (Course cr : st.courses) {
			System.out.println("选择了课程：" + cr.id + "：" + cr.name);
		}
		System.out.println("共选择了" + st.courses.size() + "课程");
		is.testContains();
	}
}

package com.collections;

import java.util.Scanner;

public class TestSet {
	public static void main(String[] args) {
		InitSet is = new InitSet();
		is.addCourse();
		is.printCourse();
		Student st = new Student("1", "jack");
		System.out.println("��ӭ�㣬" + st.name + "����ѡ�Σ�");
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("������γ�ID");
			String courseId = input.next();
			for (Course cr : is.courseList) {
				if (courseId.equals(cr.id)) {
					st.courses.add(cr);
				}
			}
		}
		for (Course cr : st.courses) {
			System.out.println("ѡ���˿γ̣�" + cr.id + "��" + cr.name);
		}
		System.out.println("��ѡ����" + st.courses.size() + "�γ�");
		is.testContains();
	}
}

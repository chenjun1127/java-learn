package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitList {
	public List courseList;

	public InitList() {
		this.courseList = new ArrayList();
	}

	/**
	 * 	��ӿγ�
	 */
	public void addCourse() {
		Course cr1 = new Course("1", "C����");
		this.courseList.add(cr1);
		Course temp = (Course) this.courseList.get(0);
		System.out.println("����˿γ̣�" + temp.id + "-->" + temp.name + "\n\t");
		Course[] course = { new Course("2", "��ѧӢ��"), new Course("3", "�ߵ���ѧ"), new Course("4", "�����������") };
		this.courseList.addAll(Arrays.asList(course));
	}

	/**
	 * 	�����γ�
	 */
	public void printCourse() {
		List arr = this.courseList;
		for (int i = 0; i < arr.size(); i++) {
			Course cr = (Course) arr.get(i);
			System.out.println("��ǰ�γ��У�" + cr.id + "-->" + cr.name);
		}
		System.out.println("\t");
	}

	/**
	 * 	�޸Ŀγ�
	 */
	public void updateCourse(int index, Course course) {
		this.courseList.set(index, course);
	}

	/**
	 * 	ɾ���γ�
	 */
	public <T> void deleteCourse(T index) {
		if (index == null || index == "") {
			this.courseList.clear();
			System.out.println("���޿γ�");
		} else {
			if (index instanceof String) {
				int i = Integer.valueOf((String) index);
				this.courseList.remove(i);
			} else if (index instanceof Integer) {
				this.courseList.remove((int) index);
			} else {
				System.out.print("�����������");
			}
		}
	}
}

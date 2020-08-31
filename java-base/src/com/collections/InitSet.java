package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitSet {
	public List<Course> courseList;

	public InitSet() {
		this.courseList = new ArrayList<Course>();
	}

	/**
	 * ��ӿγ�
	 */
	public void addCourse() {
		Course cr1 = new Course("1", "C����");
		this.courseList.add(cr1);
		Course temp = (Course) this.courseList.get(0);
		System.out.println("����˿γ̣�" + temp.id + "-->" + temp.name + "\n\t");
		Course[] course = { new Course("2", "��ѧӢ��"), new Course("3", "�ߵ���ѧ"), new Course("4", "�����������") };
		this.courseList.addAll(Arrays.asList(course));
	}

	public void printCourse() {
		List arr = this.courseList;
		for (int i = 0; i < arr.size(); i++) {
			Course cr = (Course) arr.get(i);
			System.out.println("��ǰ�γ��У�" + cr.id + "-->" + cr.name);
		}
		System.out.println("\t");
	}

	/**
	 * 	����contains
	 */
	public void testContains() {
		Course course = this.courseList.get(0);
		System.out.println("ȡ�ÿγ̣�" + course.name);
		System.out.println("�γ��б����Ƿ��У�" + course.name + "��" + this.courseList.contains(course));
		Course cr = new Course(course.id,course.name);
//		�´���һ�����󣬺��б��еĵ�һ����ȫ��ͬ����ʱ�ټ���б����Ƿ��У��������᷵��false��Ϊ����false������
//		�����������дcourse���equals��������дѭ���жϣ��Ƚ��鷳��
//		System.out.println("�γ��б����Ƿ��У�" + cr.name + "��" + this.courseList.contains(cr));
//		��д֮���
		System.out.println("�γ��б����Ƿ��У�" + cr.name + "��" + this.courseList.contains(cr));
	}
}

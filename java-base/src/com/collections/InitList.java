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
	 * 	添加课程
	 */
	public void addCourse() {
		Course cr1 = new Course("1", "C语言");
		this.courseList.add(cr1);
		Course temp = (Course) this.courseList.get(0);
		System.out.println("添加了课程：" + temp.id + "-->" + temp.name + "\n\t");
		Course[] course = { new Course("2", "大学英语"), new Course("3", "高等数学"), new Course("4", "环境艺术设计") };
		this.courseList.addAll(Arrays.asList(course));
	}

	/**
	 * 	遍历课程
	 */
	public void printCourse() {
		List arr = this.courseList;
		for (int i = 0; i < arr.size(); i++) {
			Course cr = (Course) arr.get(i);
			System.out.println("当前课程有：" + cr.id + "-->" + cr.name);
		}
		System.out.println("\t");
	}

	/**
	 * 	修改课程
	 */
	public void updateCourse(int index, Course course) {
		this.courseList.set(index, course);
	}

	/**
	 * 	删除课程
	 */
	public <T> void deleteCourse(T index) {
		if (index == null || index == "") {
			this.courseList.clear();
			System.out.println("暂无课程");
		} else {
			if (index instanceof String) {
				int i = Integer.valueOf((String) index);
				this.courseList.remove(i);
			} else if (index instanceof Integer) {
				this.courseList.remove((int) index);
			} else {
				System.out.print("传入参数错误");
			}
		}
	}
}

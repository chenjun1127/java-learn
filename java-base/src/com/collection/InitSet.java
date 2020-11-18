package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitSet {
	public List<Course> courseList;

	public InitSet() {
		this.courseList = new ArrayList<Course>();
	}

	/**
	 * 添加课程
	 */
	public void addCourse() {
		Course cr1 = new Course("1", "C语言");
		this.courseList.add(cr1);
		Course temp = (Course) this.courseList.get(0);
		System.out.println("添加了课程：" + temp.id + "-->" + temp.name + "\n\t");
		Course[] course = { new Course("2", "大学英语"), new Course("3", "高等数学"), new Course("4", "环境艺术设计") };
		this.courseList.addAll(Arrays.asList(course));
	}

	public void printCourse() {
		List<Course> arr = this.courseList;
		for (Course course : arr) {
			System.out.println("当前课程有：" + ((Course) course).id + "-->" + ((Course) course).name);
		}
		System.out.println("\t");
	}

	/**
	 * 	测试contains
	 */
	public void testContains() {
		Course course = this.courseList.get(0);
		System.out.println("取得课程：" + course.name);
		System.out.println("课程列表中是否含有：" + course.name + "，" + this.courseList.contains(course));
		Course cr = new Course(course.id,course.name);
//		新创建一个对象，和列表中的第一个完全相同，此时再检测列表中是否含有，以下语句会返回false，为何是false？？？
//		解决方法：重写course类的equals方法或者写循环判断（比较麻烦）
//		System.out.println("课程列表中是否含有：" + cr.name + "，" + this.courseList.contains(cr));
//		重写之后的
		System.out.println("课程列表中是否含有：" + cr.name + "，" + this.courseList.contains(cr));
	}
}

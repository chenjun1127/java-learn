package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class InitMap {
	public Map<String, Student> students;

	public InitMap() {
		this.students = new HashMap<String, Student>();
	}

	/**	
	 * 	��ӣ��޸ģ�
	 */
	
	public void putItems() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		while (i < 3) {
			System.out.println("������ѧ��ID��");
			String ID = input.next();
			Student st = this.students.get(ID);
			if (st == null) {
				System.out.println("������ѧ��������");
				String name = input.next();
				Student nst = new Student(ID, name);
				this.students.put(ID, nst);
				System.out.println("�ɹ���ӣ�" + this.students.get(ID).name);
				i++;
			} else {
				System.out.println("��ѧ��ID�Ѿ���ռ��");
				continue;
			}
		}
	}

	/**
	 * 	ͨ��key������map
	 */
	public void printByKey() {
		Set<String> keySet = this.students.keySet();
		for (String id : keySet) {
			Student st = this.students.get(id);
			if (st != null) {
				System.out.println("ѧ����" + st.name);
			}
		}
	}
	
	/**
	 * 	ɾ��
	 */
	
	public void delItems() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("������Ҫɾ����ѧID��");
			String ID = input.next();
			Student st = this.students.get(ID);
			if (ID == null) {
				System.out.println("��ѧ��ID�����ڣ�����������");
				continue;
			}
			this.students.remove(ID);
			System.out.println("ɾ���ɹ���" + st.name);
			break;
		}
	}
	/**
	 * 	ͨ��entrySet����������Map
	 * 	entrySet���ؼ�ֵ�Լ���
	 */
	public void printByEntry() {
		Set<Entry<String, Student>> entrySet = this.students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("ȡ�ü�Ϊ��" + entry.getKey());
			System.out.println("��ӦֵΪ��" + entry.getValue().name);
		}
	}
}

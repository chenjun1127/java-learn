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
     * 添加（修改）
     */

    public void putItems() {
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            System.out.println("请输入学生ID：");
            String ID = input.next();
            Student st = this.students.get(ID);
            if (st == null) {
                System.out.println("请输入学生姓名：");
                String name = input.next();
                Student nst = new Student(ID, name);
                this.students.put(ID, nst);
                System.out.println("成功添加：" + this.students.get(ID).name);
                i++;
            } else {
                System.out.println("该学生ID已经被占用");
                continue;
            }
        }
    }

    /**
     * 通过key来遍历map
     */
    public void printByKey() {
        Set<String> keySet = this.students.keySet();
        for (String id : keySet) {
            Student st = this.students.get(id);
            if (st != null) {
                System.out.println("学生：" + st.name);
            }
        }
    }

    /**
     * 删除
     */

    public void delItems() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要删除的学ID：");
            String ID = input.next();
            Student st = this.students.get(ID);
            if (ID == null) {
                System.out.println("该学生ID不存在，请重新输入");
                continue;
            }
            this.students.remove(ID);
            System.out.println("删除成功：" + st.name);
            break;
        }
    }

    /**
     * 通过entrySet方法来遍历Map
     * entrySet返回键值对集合
     */
    public void printByEntry() {
        Set<Entry<String, Student>> entrySet = this.students.entrySet();
        for (Entry<String, Student> entry : entrySet) {
            System.out.println("取得键为：" + entry.getKey());
            System.out.println("对应值为：" + entry.getValue().name);
        }
    }
}

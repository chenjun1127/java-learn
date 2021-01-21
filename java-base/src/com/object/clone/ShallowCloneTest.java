package com.object.clone;

import com.object.clone.entities.Student;

import java.util.Random;

/**
 * @Description: 浅克隆
 * @Author: chenjun
 * @Date: 2021/1/21 14:05
 */
public class ShallowCloneTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        Random random = new Random();
        s1.setId(random.nextInt());
        s1.setNumber(54321);
        try {
            Student s2 = (Student) s1.clone();
            System.out.println("学生1：" + s1.toString());
            System.out.println("学生2：" + s2.toString());
            s2.setId(random.nextInt());
            s2.setNumber(12345);
            System.out.println("学生1：" + s1.toString());
            System.out.println("学生2：" + s2.toString());
            System.out.println(s1 == s2); // false，不是同一个对象
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

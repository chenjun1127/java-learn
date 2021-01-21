package com.object.clone;

import com.object.clone.entities.Car;
import com.object.clone.entities.Person;

import java.io.IOException;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 14:42
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        Person p1 = new Person("jack", 30, new Car("Benz", 300));
        try {
            Person p2 = MyUtil.clone(p1);
            p2.getCar().setBrand("BYD");
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的 Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.data;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 11:34
 */
public class AutoUnBoxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3; // 将3自动装箱成Integer
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一类型
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
    }
}

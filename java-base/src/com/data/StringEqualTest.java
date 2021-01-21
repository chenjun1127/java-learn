package com.data;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 13:41
 */
public class StringEqualTest {
    public static void main(String[] args) {
        String s1 = new String("hello world");
        String s2 = "hello world";
        String s3 = "hello";
        String s4 = " world";
        String s5 = "hello" + " world";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());

    }
}

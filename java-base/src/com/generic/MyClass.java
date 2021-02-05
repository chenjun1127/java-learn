package com.generic;

/**
 * @Description: 泛型
 * @Author: chenjun
 * @Date: 2021/2/5 14:04
 */
public class MyClass {
    public static void main(String[] args) {
        TestObj<String> tomb = new TestObj<>();
        tomb.print("test");
    }
}

class TestObj<T> {
    public void print(T t) {
        System.out.println(t);
    }
}
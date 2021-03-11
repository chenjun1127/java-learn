package com.single;

/**
 * @Description: 饿汉单例
 * @Author: chenjun
 * @Date: 2021/3/11 10:27
 */
public class Hungry {
    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }
}

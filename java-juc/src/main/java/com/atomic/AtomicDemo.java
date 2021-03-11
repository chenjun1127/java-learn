package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: volatile特性：1、保持可见性；2、不保证原子性；3、禁止指定重排
 * @Author: chenjun
 * @Date: 2021/3/11 9:55
 */
public class AtomicDemo {
    // 原子类，解决不保证原子性，此处不能用volatile
    private static final AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
            }).start();
        }
        // 默认有两个线程，main和gc
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ": " + num);
    }


    private static void add() {
        num.getAndIncrement();
    }
}

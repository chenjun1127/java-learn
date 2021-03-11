package com.base;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 减法计数器
 * @Author: chenjun
 * @Date: 2021/3/10 13:40
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Go out!");
                // 数量减1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            // 等待计数器归0，再向下执行
            countDownLatch.await();
            System.out.println("Close Door");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

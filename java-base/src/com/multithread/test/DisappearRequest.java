package com.multithread.test;

/**
 * @Description: 线程不安全例子(消失的请求)
 * @Author: chenjun
 * @Date: 2020/11/18 9:51
 */
public class DisappearRequest implements Runnable {
    static DisappearRequest instance = new DisappearRequest();
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        // 等线程执行完
        t1.join();
        t2.join();
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }
}

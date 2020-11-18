package com.multithread.test;

/**
 * @Description: 类锁的第一种形式，加在static静态方法上
 * @Author: chenjun
 * @Date: 2020/11/18 11:15
 */
public class SynchronizedStatic implements Runnable {
    static SynchronizedStatic instance1 = new SynchronizedStatic();
    static SynchronizedStatic instance2 = new SynchronizedStatic();

    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }

    private static synchronized void method() {
        System.out.println("我是类锁的第一种形式：static，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}

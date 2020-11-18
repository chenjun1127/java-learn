package com.multithread.test;

/**
 * @Description: 对象锁方法修饰符形式
 * @Author: chenjun
 * @Date: 2020/11/18 10:57
 */
public class SynchronizedObject implements Runnable {
    static SynchronizedObject instance = new SynchronizedObject();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    private synchronized void method() {
        System.out.println("我的对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}

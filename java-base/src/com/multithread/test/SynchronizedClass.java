package com.multithread.test;

/**
 * @Description: 类锁的第二种形式，应用在.class上
 * @Author: chenjun
 * @Date: 2020/11/18 11:15
 */
public class SynchronizedClass implements Runnable {
    static SynchronizedClass instance1 = new SynchronizedClass();
    static SynchronizedClass instance2 = new SynchronizedClass();

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

    private void method() {
        synchronized (SynchronizedClass.class) {
            System.out.println("我是类锁的第二种形式：synchronized(*.class)，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}

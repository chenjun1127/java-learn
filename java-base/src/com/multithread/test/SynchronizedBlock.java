package com.multithread.test;

/**
 * @Description: synchronized一种是对象锁this,另一种可以是新建一个对象
 * @Author: chenjun
 * @Date: 2020/11/18 10:25
 */
public class SynchronizedBlock implements Runnable {
    static SynchronizedBlock instance = new SynchronizedBlock();

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
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行结束");
        }
    }
}
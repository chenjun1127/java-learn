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
    // 线程安全问题
    // 核心思想：同一个时刻，只能有一个线程执行，那么这个时候整个程序就会变成单线程执行。加个锁缺点：对程序效率执行非常低。
    // 如何解决线程安全问题？
    // synchronized，Lock锁，cas无锁，手写乐观锁
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
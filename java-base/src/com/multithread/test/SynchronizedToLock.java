package com.multithread.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/18 14:50
 */
public class SynchronizedToLock {
    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("我是synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        } finally {
            lock.unlock();
        }
    }

    // 以上两个方法是等价的
    public static void main(String[] args) {
        SynchronizedToLock synchronizedToLock = new SynchronizedToLock();
        synchronizedToLock.method1();
        synchronizedToLock.method2();
    }
}

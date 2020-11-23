package com.multithread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁
 * @Author: chenjun
 * @Date: 2020/11/23 11:12
 */
public class MyTask {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        testWriteTask(myTask);
        testReadTask(myTask);
    }


    private static void testReadTask(MyTask myTask) {
        for (int i = 0; i < 10; i++) {
            new Thread(myTask::read).start();
        }
    }

    private static void testWriteTask(MyTask myTask) {
        for (int i = 0; i < 10; i++) {
            new Thread(myTask::write).start();
        }
    }

    /**
     * 如果多个线程同时读取的情况下，读读共享
     */
    private void read() {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "，开始读取数据");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "，结束读取数据");
        lock.readLock().unlock();
    }
    /**
     * 如果多个线程同时写的情况下，写写互斥（不能同时执行，只能单个线程）
     */
    private void write() {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "，开始写入数据");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "，结束写入数据");
        lock.writeLock().unlock();
    }
}

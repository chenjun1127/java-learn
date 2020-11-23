package com.multithread.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Lock锁运用
 * @Author: chenjun
 * @Date: 2020/11/23 9:25
 */
public class TicketLock extends Thread {
    // 票数
    private int count = 100;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public void ticket() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            lock.lock();
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "，正在出票" + (100 - count + 1) + "张");
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TicketLock ticketLock = new TicketLock();
        new Thread(ticketLock, "窗口1").start();
        new Thread(ticketLock, "窗口2").start();
    }
}

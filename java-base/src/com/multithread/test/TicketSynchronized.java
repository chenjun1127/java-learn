package com.multithread.test;

/**
 * @Description: synchronized锁运用
 * @Author: chenjun
 * @Date: 2020/11/23 9:25
 */
public class TicketSynchronized extends Thread {
    // 票数
    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public synchronized void ticket() {
        if (count > 0) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "，正在出票" + (100 - count + 1) + "张");
            count--;
        }
    }

    public static void main(String[] args) {
        TicketSynchronized ticketSynchronized = new TicketSynchronized();
        new Thread(ticketSynchronized, "窗口1").start();
        new Thread(ticketSynchronized, "窗口2").start();
    }
}

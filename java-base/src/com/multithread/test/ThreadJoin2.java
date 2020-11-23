package com.multithread.test;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/23 15:34
 */
public class ThreadJoin2 implements Runnable {
    private final Thread t;

    public ThreadJoin2(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        if (t != null) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }

    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(new ThreadJoin2(null), "t1");
            Thread t2 = new Thread(new ThreadJoin2(t1), "t2");
            Thread t3 = new Thread(new ThreadJoin2(t2), "t3");
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

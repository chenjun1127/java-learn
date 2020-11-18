package com.multithread.base;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/17 18:02
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new ThreadInit()).start();
    }

    static class ThreadInit extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，我是子线程");
        }
    }
}

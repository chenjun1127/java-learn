package com.multithread.base;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/17 17:24
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "，我是子线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "，我是主线程");
        new Thread(new RunnableTest()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "，我是子线程");
            }
        }).start();
    }
}

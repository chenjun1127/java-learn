package com.multithread.test;

/**
 * @Description: join顺序执行
 * @Author: chenjun
 * @Date: 2020/11/23 15:10
 */
public class ThreadJoin1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }
    /**
     * 主线程调用了t线程，主线程此时阻塞释放锁、必须等t线程执行完毕的情况下，主线程才能继续执行，其实变成单线程了
     */
    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(new ThreadJoin1(), "t1");
            Thread t2 = new Thread(new ThreadJoin1(), "t2");
            Thread t3 = new Thread(new ThreadJoin1(), "t3");
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

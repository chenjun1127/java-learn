package com.multithread.base;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/20 17:34
 */
public class BaseThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
            }
        });
        //  thread.setDaemon(true)->守护线程，当主线程结束时，守护线程也随主线程结束；
        //  thread.setDaemon(false)->用户线程，当主线程结束时，用户线程不会结束，
        thread.setDaemon(true);  // 默认为false，用户进程
        thread.start();
        System.out.println(Thread.currentThread().getName() + "，主线线程代码执行完毕，结束！");
    }
}

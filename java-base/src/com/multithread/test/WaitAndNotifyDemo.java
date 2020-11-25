package com.multithread.test;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/25 9:47
 */
public class WaitAndNotifyDemo {
    static class User {
        private String userName;
        private String sex;
        // 锁变量值，共享对象的flag值为false的情况下，则只能写不能读，flag值为true的情况下，只能读不能写
        private Boolean flag = false;
    }

    // 写
    static class InputThread extends Thread {
        private final User user;

        public InputThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < 1000; i++) {
                synchronized (user) {
                    if (user.flag) {
                        try {
                            user.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0) {
                        user.userName = "Jack";
                        user.sex = "男";
                    } else {
                        user.userName = "Lily";
                        user.sex = "女";
                    }
                    user.flag = true;
                    // 唤醒消费者线程，变为就绪状态
                    user.notify();
                    count = (count + 1) % 2;
                }
            }
        }
    }

    // 读
    static class OutThread extends Thread {
        private final User user;

        public OutThread(User user) {
            this.user = user;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (user) {
                    if (!user.flag) {
                        try {
                            // 释放user锁，当前线程阻塞
                            user.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(user.userName + "," + user.sex + "--->" + i);
                    user.flag = false;
                    user.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        new WaitAndNotifyDemo().start();
    }

    public void start() {
        User user = new User();
        // 写的线程
        new InputThread(user).start();
        // 读的线程
        new OutThread(user).start();
    }
}

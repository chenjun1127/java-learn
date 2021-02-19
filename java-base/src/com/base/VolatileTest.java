package com.base;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/2/19 15:22
 */
public class VolatileTest {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        while (true) {
            synchronized (a) {
                if (a.isFlag()) {
                    System.out.println("有点东西");
                }
            }
        }
    }
}

class A extends Thread {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag:" + true);
    }
}

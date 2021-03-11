package com.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/10 11:42
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"A").start();
        try {
            String s = futureTask.get();
            System.out.println(Thread.currentThread().getName() + ": " + s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<String> {
    @Override
    public String call() {
        System.out.println("call方法调用了。。。");
        return "123";
    }
}
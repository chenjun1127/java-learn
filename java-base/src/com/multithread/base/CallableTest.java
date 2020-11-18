package com.multithread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/17 17:14
 */
public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + "，正在开始执行异步发送短信");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "异步发送短信";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 可以获取当前线程返回结果
        FutureTask<String> futureTask = new FutureTask<>(new CallableTest());
        new Thread(futureTask).start();
        // 等待线程执行完毕获取返回结果
        System.out.println("result：" + futureTask.get());
    }
}

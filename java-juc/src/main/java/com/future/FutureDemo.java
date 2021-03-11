package com.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 异步任务
 * @Author: chenjun
 * @Date: 2021/3/11 8:59
 */
public class FutureDemo {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * @Description: 无返回值的异步回调
     * @Return void
     */
    private static void test1() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "runAsync");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("1111");
        try {
            completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 有返回值的异步回调，类似ajax
     * @Return void
     */
    private static void test2() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync");
            return 1024;
        });
        // 成功或者失败
        try {
            completableFuture.whenComplete((t, u) -> {
                System.out.println("t=>" + t);
                System.out.println("u=>" + u);
            }).exceptionally((e) -> {
                e.printStackTrace();
                return null;
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

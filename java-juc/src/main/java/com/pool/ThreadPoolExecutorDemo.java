package com.pool;

import java.util.concurrent.*;

/**
 * @Description: Executors线程池
 * @Author: chenjun
 * @Date: 2021/3/10 15:33
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 自定义线程池
        ExecutorService service = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            // 最大承载：queue + max，超出最大，会抛出异常(由四大拒绝策略决定，也可以不抛出异常)
            for (int i = 1; i <= 8; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}

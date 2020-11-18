package com.multithread.base;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/17 18:07
 */
public class ExecutorServiceTest {
    // 当创建的线程池大于maximumPoolSize时，直接执行了拒绝策略抛出异常。（改为2可以看到）
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new ThreadTask());
        }
    }

    static class ThreadTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，我是子线程");
        }
    }
}

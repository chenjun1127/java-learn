package com.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Description: 计算，数字累加
 * @Author: chenjun
 * @Date: 2021/3/10 18:04
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private final long start;
    private final long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long temp = 10000L;
        if ((end - start) < temp) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 中间值
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            // 拆分任务，把任务压入到线程队列；
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            // 拆分任务，把任务压入到线程队列；
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}

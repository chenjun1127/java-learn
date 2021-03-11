package com.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/10 18:17
 */
public class TestResult {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * @Description: 初级
     * @Return void
     */
    private static void test1() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1L; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms, sum:=>" + sum);
    }

    /**
     * @Description: 中级
     * @Return void
     */
    private static void test2() {
        try {
            long start = System.currentTimeMillis();
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            ForkJoinTask<Long> submit = forkJoinPool.submit(new ForkJoinDemo(0L, 10_0000_0000L));
            Long sum = submit.get();
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start) + "ms, sum:=>" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 高级（stream并行流计算）
     * @Return void
     */
    private static void test3() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms, sum:=>" + sum);
    }
}

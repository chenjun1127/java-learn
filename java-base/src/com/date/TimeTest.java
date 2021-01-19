package com.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 时间戳方法测试
 * @Author: chenjun
 * @Date: 2021/1/19 10:58
 */
public class TimeTest {
    static long TEN_THOUSAND = 10000;

    public static void main(String[] args) {
        long times = TEN_THOUSAND * 1000;
        long t1 = System.currentTimeMillis();
        testSystem(times);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时：" + (t2 - t1) + "ms");
        testCalendar(times);
        long t3 = System.currentTimeMillis();
        System.out.println("耗时：" + (t3 - t2) + "ms");
        testDate(times);
        long t4 = System.currentTimeMillis();
        System.out.println("耗时：" + (t4 - t3) + "ms");

    }

    private static void testSystem(long times) {
        for (int i = 0; i < times; i++) {
            long currentTime = System.currentTimeMillis();
        }
    }

    public static void testCalendar(long times) {
        for (int i = 0; i < times; i++) {
            long currentTime = Calendar.getInstance().getTimeInMillis();
        }
    }

    public static void testDate(long times) {
        for (int i = 0; i < times; i++) {
            long currentTime = new Date().getTime();
        }
    }
}

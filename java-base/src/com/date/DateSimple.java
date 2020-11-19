package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description: SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为static，必须加锁，或者使用 DateUtils 工具类。
 * @Author: chenjun
 * @Date: 2020/11/19 14:53
 */
public class DateSimple {
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 50, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000));

    /**
     * 通过打印dateString.equals(dateString2)，可以看到结果都为true，如果没有加ThreadLocal，有返回是false，表明线程不安全
     */
    public void test() {
        for (int i = 0; i < 500; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    SimpleDateFormat simpleDateFormat = threadLocal.get();
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dateString = simpleDateFormat.format(new Date());
                    try {
                        Date parseDate = simpleDateFormat.parse(dateString);
                        String dateString2 = simpleDateFormat.format(parseDate);
                        System.out.println(dateString.equals(dateString2));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        new DateSimple().test();
    }
}

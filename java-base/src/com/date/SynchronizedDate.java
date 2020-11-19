package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/19 15:57
 */
public class SynchronizedDate {
    public static void main(String[] args) {

        new SynchronizedDate().test();
    }

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 200, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000));

    public void test() {
        for (int i = 0; i < 500; i++) {
            threadPoolExecutor.execute(() -> {
                synchronized (simpleDateFormat) {
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
}

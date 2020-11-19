package com.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/19 15:36
 */
public class InstantSimple {
    public static void main(String[] args) {
        // 通过这种方式获取的时间戳与北京时间相差8个时区，需要修正为北京时间，通过查看源代码发现Instant.now()使用等是UTC时间Clock.systemUTC().instant()。
        Instant instant = Instant.now();
        System.out.println("UTC时间：" + instant);
        // 增加8小时
        Instant now = instant.plusMillis(TimeUnit.HOURS.toMillis(8)); // 8小时转为毫秒数
        System.out.println("now:" + now);
        System.out.println("秒数：" + now.getEpochSecond());
        System.out.println("毫秒数：" + now.toEpochMilli());
        // LocalDateTime输出毫秒数的方式，比Instant多一步转换
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant localDateTimeToInstant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("LocalDateTime 毫秒数:" + localDateTimeToInstant.toEpochMilli());
    }
}

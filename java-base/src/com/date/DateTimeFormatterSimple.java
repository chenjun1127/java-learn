package com.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/19 15:29
 */
public class DateTimeFormatterSimple {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
        // 格式化日期
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String strDate = localDateTime.format(dateTimeFormatter);
        System.out.println(strDate);
        // 解析日期
        LocalDateTime localDateTime1 = LocalDateTime.parse("2020/11/19 15:23:46", dateTimeFormatter);
        System.out.println(localDateTime1); // 2020-11-19T15:23:46
    }
}

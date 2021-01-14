package com.data;

import java.text.DecimalFormat;

/**
 * @Description: 数字格式化
 * @Author: chenjun
 * @Date: 2021/1/14 11:52
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        double pi = 3.1415927;//圆周率
        System.out.println(new DecimalFormat("0").format(pi));
        // 取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));
        // 取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));
        // 取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));
        // 以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));
        int p = 1299792458;
        // 每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(p));
        System.out.println(new DecimalFormat(",##").format(p));
        System.out.println(new DecimalFormat("###,##").format(p));
    }
}

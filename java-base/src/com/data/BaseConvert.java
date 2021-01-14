package com.data;

/**
 * @Description: 进制转化
 * @Author: chenjun
 * @Date: 2021/1/14 11:45
 */
public class BaseConvert {
    public static void main(String[] args) {
        int i = 20;
        String binaryString = Integer.toBinaryString(i);
        System.out.println("十进制转二进制：" + binaryString);
        String hexString = Integer.toHexString(i);
        System.out.println("十进制转十六进制：" + hexString);
        String octalString = Integer.toOctalString(i);
        System.out.println("十进制转八进制：" + octalString);
    }
}

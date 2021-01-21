package com.data;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/14 11:43
 */
public class StringTest {
    public static void main(String[] args) {
        base();
        testChar();
    }

    private static void base() {
        byte[] bytes = {97, 98, 99};
        String s1 = new String(bytes);
        System.out.println(s1);
        String s2 = new String(bytes, 1, 2);
        System.out.println(s2);
        char[] chars = {'我', '是', '中', '国', '人'};
        String s3 = new String(chars);
        System.out.println(s3);
        String s4 = new String(chars, 2, 3);
        System.out.println(s4);
        try {
            String s5 = new String(s3.getBytes("GB2312"),"ISO-8859-1");
            System.out.println(s5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void testChar() {
        String s = "我是中国人";
        char c = s.charAt(0);
        char[] chars = s.toCharArray();
        System.out.println(c);
        System.out.println(Arrays.toString(chars));
    }
}
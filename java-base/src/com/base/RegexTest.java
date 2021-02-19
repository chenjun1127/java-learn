package com.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 正则判断字符串是否是数字
 * @Author: chenjun
 * @Date: 2021/2/19 16:23
 */
public class RegexTest {
    public static void main(String[] args) {
        String s = "1254";
        System.out.println(isNumeric(s));
    }

    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

}

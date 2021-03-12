package com.spring.base.aop;

import java.util.Date;

/**
 * @Description: aop 前置通知和后置通知
 * @Author: chenjun
 * @Date: 2020/7/23 9:35
 */
public class TimeHandler {
    public void printBefore() {
        System.out.println("printBefore time=" + new Date());
    }

    public void printAfter() {
        System.out.println("printAfter time=" + new Date());
    }
}

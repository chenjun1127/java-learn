package com.spring.base_learn.aop;

import java.util.Date;

/**
 * @Description: aop 前置通知和后置通知
 * @author: chenjun
 * @date: 2020年7月23日 上午11:17:47
 */
public class TimeHandler {
	public void printBefore() {
		System.out.println("printBefore time=" + new Date());
	}
	
	public void printAfter() {
		System.out.println("printAfter time=" + new Date());
	}
}

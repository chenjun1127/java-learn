package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chenjun
 * 2020年6月22日 上午10:52:56 通过 Callable 和 Future 创建线程
 */
public class CallableAndFutureTest implements Callable<Integer> {
	public static void main(String[] args) {
		CallableAndFutureTest caf = new CallableAndFutureTest();
		FutureTask<Integer> ft = new FutureTask<Integer>(caf);
		for (int i = 0; i < 100; i++) {
			{
				System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
				if (i == 20) {
					new Thread(ft, "有返回值的线程").start();
				}
			}
		}
		try {
			System.out.println("子线程的返回值：" + ft.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
}

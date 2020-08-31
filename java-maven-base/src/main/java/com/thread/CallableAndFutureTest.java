package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chenjun
 * 2020��6��22�� ����10:52:56 ͨ�� Callable �� Future �����߳�
 */
public class CallableAndFutureTest implements Callable<Integer> {
	public static void main(String[] args) {
		CallableAndFutureTest caf = new CallableAndFutureTest();
		FutureTask<Integer> ft = new FutureTask<Integer>(caf);
		for (int i = 0; i < 100; i++) {
			{
				System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵ" + i);
				if (i == 20) {
					new Thread(ft, "�з���ֵ���߳�").start();
				}
			}
		}
		try {
			System.out.println("���̵߳ķ���ֵ��" + ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
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

package com.springboot.study.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @Description: 异步任务  async注解 注释掉，就变成同步了
 * @author: chenjun
 * @date: 2020年6月30日 下午4:47:40
 */
@Component
@Async
public class AsyncTask {

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void test1() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(1000L);
		long end = System.currentTimeMillis();
		System.out.println("任务1耗时：" + (end - begin));
	}

	public void test2() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(2000L);
		long end = System.currentTimeMillis();
		System.out.println("任务2耗时：" + (end - begin));
	}

	public void test3() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(3000L);
		long end = System.currentTimeMillis();
		System.out.println("任务3耗时：" + (end - begin));
	}

	public Future<String> test4() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(4000L);
		long end = System.currentTimeMillis();
		System.out.println("任务3耗时：" + (end - begin));
		return new AsyncResult<String>("任务4");
	}

	public Future<String> test5() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(3000L);
		long end = System.currentTimeMillis();
		System.out.println("任务5耗时：" + (end - begin));
		return new AsyncResult<String>("任务5");
	}

	public Future<String> test6() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(1000L);
		long end = System.currentTimeMillis();
		System.out.println("任务3耗时：" + (end - begin));
		return new AsyncResult<String>("任务6");
	}

}

package com.springboot.study.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.task.AsyncTask;
import com.springboot.study.utils.JsonData;

/**
 * @Description: 异步任务
 * @author: chenjun
 * @date: 2020年6月30日 下午5:03:54
 */
@RestController
@RequestMapping("/api/async")
public class AsyncTaskController {

	@Autowired
	private AsyncTask task;
 
	/**    
	 * @Description: 无需等待异步结果
	 * @param: @return
	 * @param: @throws InterruptedException      
	 * @return: JsonData      
	 * @throws   
	 */
	@GetMapping("/task")
	public JsonData asyncTaskWithNoResult() throws InterruptedException {
		long begin = System.currentTimeMillis();
		task.test1();
		task.test1();
		task.test3();
		long end = System.currentTimeMillis();
		long total = end - begin;
		return JsonData.buildSuccess(total);
	}

	 
	/**    
	 * @Description: 等待异步任务返回结果 
	 * @param: @return
	 * @param: @throws InterruptedException      
	 * @return: JsonData      
	 * @throws   
	 */
	@GetMapping("/taskWithResult")
	public JsonData asyncTaskWithResult() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Future<String> task4 = task.test4();
		Future<String> task5 = task.test5();
		Future<String> task6 = task.test6();
		for (;;) {
			if (task4.isDone() && task5.isDone() && task6.isDone()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		long total = end - begin;	
		return JsonData.buildSuccess(total);
	}

}

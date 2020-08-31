package com.springboot.study.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: 定时任务
 * @author: chenjun
 * @date: 2020年6月30日 下午4:08:15
 */
@Component
public class TaskTimer {

	/**
	 * @Description: 每2秒执行 ，但延迟了4秒
	 * @param: 
	 * @return: void 
	 * @throws InterruptedException 
	 */
//	@Scheduled(fixedRate = 2000)
//	public void getRandom() throws InterruptedException {
//		Thread.sleep(4000L);
//		System.out.println("当前时间：" + new Date());
//	}

	/**
	 * @Description: 每天16点30分触发
	 * @param: 
	 * @return: void 
	 * @throws
	 */
	@Scheduled(cron = "0 30 16 * * ? ")
	public void print() {
		System.out.println("每天16点30分触发");
	}

}

package com.springboot.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 服务端向客户端推送（html5的sse方式），必须以data:开头
 * @author: chenjun
 * @date: 2020年7月8日 下午2:16:50
 */
@RestController
public class SSEController {
	@RequestMapping(value = "/sse/data", produces = "text/event-stream;charset=UTF-8")
	public String push() throws InterruptedException {
		Thread.sleep(1000);
		return "data:" + Math.random() + "\n\n";
	}
}

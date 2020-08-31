package com.springboot.study.controller;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.utils.JsonData;

/**
 * @Description: 生产者
 * @author: chenjun
 * @date: 2020年7月7日 下午4:11:26
 */
@RestController
@RequestMapping("/activemq")
public class ProducerController {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Queue queue;

	@Autowired
	private Topic topic;

	@PostMapping("/queue/test")
	public JsonData sendQueue(@RequestBody String str) {
		this.sendMessage(this.queue, str);
		return JsonData.buildSuccess("success");
	}

	@PostMapping("/topic/test")
	public JsonData sendTopic(@RequestBody String str) {
		this.sendMessage(this.topic, str);
		return JsonData.buildSuccess("success");
	}
	
	/**    
	 * @Description: TODO
	 * @param: @param destination
	 * @param: @param msg      
	 * @return: void      
	 * @throws   
	 */
	private void sendMessage(Destination destination, final String msg) {
		jmsMessagingTemplate.convertAndSend(destination, msg);
	}
}

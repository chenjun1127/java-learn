package com.springboot.study.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 消费者
 * @author: chenjun
 * @date: 2020年7月7日 下午4:24:40
 */
@Component
public class Consumer {

	// 接收queue类型消息
	// destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
	@JmsListener(destination = "springboot.queue")
	public void ListenQueue(String msg) {
		System.out.println("接收到queue消息：" + msg);
	}

	// 接收topic类型消息
	// destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
	// containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
	@JmsListener(destination = "springboot.topic", containerFactory = "jmsTopicListenerContainerFactory")
	public void ListenTopic(String msg) {
		System.out.println("接收到topic消息：" + msg);
	}
}

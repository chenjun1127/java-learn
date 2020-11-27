package com.spring.base.learn.config;

import com.spring.base.learn.entity.Order;
import com.spring.base.learn.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: @Configuration 和 @Bean 注解
 * @author: chenjun
 * @date: 2020年7月21日 下午6:16:44
 */
@Configuration
public class ApplicationConfig {
	@Bean
	public Student student() {
		return new Student();
	}

	@Bean
	public Order order() {
		return new Order();
	}
}

package com.springboot.study.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**    
 * @description: 拦截器
 * @author: chenjun
 * @date: 2020年6月29日 上午9:26:35    
 */
@Configuration
public class CustomIntecpter implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/testIntecpter");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}

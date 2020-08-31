package com.springboot.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**    
 * @Description:启动类 
 * @author: chenjun
 * @date:   2020年6月28日 下午2:34:02    
 */
@SpringBootApplication
@ServletComponentScan
@EnableScheduling // 定时
@EnableAsync // 异步
@MapperScan("com.springboot.study.mapper")
@EnableElasticsearchRepositories
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	} 		
}

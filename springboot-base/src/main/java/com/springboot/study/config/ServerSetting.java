package com.springboot.study.config;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:实体类读取配置
 * @author: chenjun
 * @date: 2020年6月28日 下午2:34:26
 */
@Component
@PropertySource({ "classpath:application.properties" })
//@ConfigurationProperties(prefix="application") // 如果加前缀，bean属性如果和配置的key一一对应，下方的@value就不需要加；
public class ServerSetting {
	@Value("${application.domain}")
	private String domain;
	@Value("${application.env}")
	private String env;
	@Value("${application.title}")
	private String title;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

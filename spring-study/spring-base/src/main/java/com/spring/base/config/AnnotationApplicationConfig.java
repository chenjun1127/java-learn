package com.spring.base.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description: 全注解方式配置aop,也可以全xml方式，还可以半注解半xml方式
 * @Author: chenjun
 * @Date: 2020/7/23 15:09
 */
@Configuration
@EnableAspectJAutoProxy // 告诉spring支持aspect
@ComponentScan("com.spring.base.service.impl")
public class AnnotationApplicationConfig {
}

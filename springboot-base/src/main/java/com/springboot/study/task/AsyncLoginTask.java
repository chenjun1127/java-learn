package com.springboot.study.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Description: 模拟登录，多线程
 * @Author: chenjun
 * @Date: 2020/11/20 15:58
 */
@Component
public class AsyncLoginTask {
    private final Logger logger = LoggerFactory.getLogger(AsyncLoginTask.class);

    /**
     * 伪代码：异常多线程，无返回结果的
     */
    @Async
    public void asyncLogin() {
        login();
        sendSms();
        sendEmail();
    }

    /**
     * 伪代码：异常多线程，有返回结果的
     */
    @Async
    public Future<String> futureAsyncLogin() {
        login();
        sendSms();
        sendEmail();
        return new AsyncResult<>("异步执行登录、发送短信、邮件");
    }

    /**
     * 登录，需要请求数据库
     */
    private void login() {
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("模拟登录，耗时：" + (end - begin));
    }

    /**
     * 登录，发送短信
     */
    private void sendSms() {
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("模拟发送短信，耗时：" + (end - begin));
    }

    /**
     * 登录，发送邮件
     */
    private void sendEmail() {
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("模拟发送邮件，耗时：" + (end - begin));
    }

}

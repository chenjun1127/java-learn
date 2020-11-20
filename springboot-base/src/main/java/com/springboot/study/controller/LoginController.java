package com.springboot.study.controller;

import com.springboot.study.task.AsyncLoginTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/20 16:08
 */
@RestController
public class LoginController {
    @Resource
    private AsyncLoginTask asyncLoginTask;

    @GetMapping("/asyncable/login")
    public String asyncogin() {
        long begin = System.currentTimeMillis();
        asyncLoginTask.asyncLogin();
        long end = System.currentTimeMillis();
        return "登录成功，耗时：" + (end - begin);
    }

    @GetMapping("/asyncable/future/login")
    public String futureAsyncLogin() throws ExecutionException, InterruptedException {
        // asyncLoginTask.futureAsyncLogin(); 当不取结果的时候，直接返回
        long begin = System.currentTimeMillis();
        Future<String> future = asyncLoginTask.futureAsyncLogin();
        String result = future.get();
        long end = System.currentTimeMillis();
        return result + "，总耗时：" + (end - begin);
    }
}

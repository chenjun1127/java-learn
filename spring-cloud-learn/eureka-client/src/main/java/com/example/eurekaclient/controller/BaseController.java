package com.example.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 生产者服务
 * @Author: chenjun
 * @Date: 2020/10/10 14:07
 */
@RestController
public class BaseController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + ", this is eureka client";
    }
}

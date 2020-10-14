package com.example.serviceconsumerfeign.controller;

import com.example.serviceconsumerfeign.service.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/10 16:15
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private FeignClientService feignClientService;

    @GetMapping("/hello/{name}")
    public String feignHello(@PathVariable String name) {
        String result = feignClientService.feignHello(name);
        System.out.println("Feign result==:" + result);
        return result;
    }
}

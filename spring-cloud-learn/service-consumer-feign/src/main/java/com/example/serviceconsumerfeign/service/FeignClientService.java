package com.example.serviceconsumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/10 16:073
 */
@FeignClient(name = "eureka-client")
public interface FeignClientService {
    @GetMapping("/hello/{name}")
    String feignHello(@PathVariable("name") String name);
}

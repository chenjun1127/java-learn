package com.example.serviceconsumerribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 消费者ribbon
 * @Author: chenjun
 * @Date: 2020/10/10 15:33
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public String helloService(String name) {
        String result = restTemplate.getForObject("http://eureka-client/hello/" + name, String.class);
        System.out.println("Ribbon result==:" + result);
        return result;
    }
}

package com.example.serviceconsumerribbon.controller;

import com.example.serviceconsumerribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/10/10 15:36
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return ribbonService.helloService(name);
    }
}

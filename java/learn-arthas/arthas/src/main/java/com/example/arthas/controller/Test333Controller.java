package com.example.arthas.controller;

import com.example.arthas.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * zbj: created on 2021/2/12 21:05.
 */
@Slf4j
@RestController
public class Test333Controller {

    @Resource
    private HelloService helloService;

    @GetMapping("/test3")
    public String test3(@RequestParam String name) {
        log.info("test3 name#{}", name);
        helloService.sayHello(name);
        return "ok";
    }

}

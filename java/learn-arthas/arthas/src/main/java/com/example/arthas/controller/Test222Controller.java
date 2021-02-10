package com.example.arthas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Test222Controller {

    @GetMapping("/test2")
    public String test1() {
        log.debug("test222222222");
        return "ok";
    }

}

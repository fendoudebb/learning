package com.example.arthas.controller;

import com.example.arthas.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class Test222Controller {

    @Resource
    private TestConfig testConfig;

    @GetMapping("/test2")
    public String test1() {
        log.debug("test222222222");
        return testConfig.getUrl() + "---" + testConfig.getIsTest() + "---" + testConfig.getMaxConn();
    }

}

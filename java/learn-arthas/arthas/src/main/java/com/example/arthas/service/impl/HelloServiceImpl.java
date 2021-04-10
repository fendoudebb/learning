package com.example.arthas.service.impl;

import com.example.arthas.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * zbj: created on 2021/2/12 21:04.
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        log.info("say hello#{}", name);
    }
}

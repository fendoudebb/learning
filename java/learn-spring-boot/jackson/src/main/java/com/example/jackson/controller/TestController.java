package com.example.jackson.controller;

import com.example.jackson.view.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/")
    public Test test() {
        Test test = new Test();
        test.setId("this is id");
        test.setName("this is name");
        test.setDate(new Date());
        return test;
    }

}

package com.example.lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
public class LbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbApplication.class, args);
    }

    @GetMapping("/{id}")
    public String test3(@PathVariable String id, HttpServletRequest request) {
        System.out.println(id);
        return String.valueOf(id);
    }

}

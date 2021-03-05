package com.example.formurlencode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
public class FormurlencodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormurlencodeApplication.class, args);
    }

    @GetMapping("/test")
    public String test(@RequestParam("name") String name, HttpServletRequest request) {
        System.out.println("request param#" + name);

        String name1 = request.getParameter("name");
        System.out.println("get parameter#" + name1);

        String queryString = request.getQueryString();
        System.out.println("request query string#" + queryString);
        return name;
    }

}

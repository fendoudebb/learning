package com.test.myspringbootstartertest;

import com.example.myspringbootstarter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootStarterTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootStarterTestApplication.class, args);
    }

    @Autowired
    private TestService testService;

    @Override
    public void run(String... args) throws Exception {
        String say = testService.say();
        System.out.println(say);
    }
}

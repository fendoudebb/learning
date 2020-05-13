package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.mongo.JacksonMongoSessionConverter;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.Duration;

@RestController
@SpringBootApplication
//@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 60, collectionName = "mongo_session")
@EnableMongoHttpSession
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public JdkMongoSessionConverter jdkMongoSessionConverter() {
//        return new JdkMongoSessionConverter(Duration.ofMinutes(30));
//    }

    @Bean
    JacksonMongoSessionConverter mongoSessionConverter() {
        return new JacksonMongoSessionConverter();
    }

    @PostMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("testKey", "testValue");
        return "login success";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "logout success";
    }

    @GetMapping("/attr")
    public String attr(HttpSession session) {
        Object testKey = session.getAttribute("testKey");
        return testKey == null ? "null" : ((String) testKey);
    }

}

package com.example.demo;

import com.example.demo.vo.UserVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostMapping("/test")
    public String test(@Valid @RequestBody UserVo userVo) {
        return "ok";
    }

}

/*
{
    "name": "123",
    "email": "111@com",
    "age": 0,
    "negative": -1,
    "positive": 1,
    "info": {
        "integer1": 0,
        "integer2": 1,
        "hobbies": [
            "basketball",
            "basketball",
            "basketball"
        ],
        "skills": [
            "Java",
            "PHP",
            "Rust"
        ]
    }
}
*/
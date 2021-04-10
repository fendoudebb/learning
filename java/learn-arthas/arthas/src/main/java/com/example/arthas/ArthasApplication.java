package com.example.arthas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ArthasApplication {

    private static ConfigurableApplicationContext cac;

    public static void main(String[] args) {
        cac = SpringApplication.run(ArthasApplication.class, args);
    }

}

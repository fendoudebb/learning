package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        resourceUtil();

        classPathResource();
    }

    private void resourceUtil() throws IOException {
        File file = ResourceUtils.getFile("classpath:application.properties");
        Files.lines(file.toPath()).forEach(System.out::println);
    }

    private void classPathResource() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application.properties");
        InputStream inputStream = classPathResource.getInputStream();
        File file = classPathResource.getFile();
        Files.lines(file.toPath()).forEach(System.out::println);
    }
}

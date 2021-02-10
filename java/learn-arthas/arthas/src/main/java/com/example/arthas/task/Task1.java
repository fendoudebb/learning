package com.example.arthas.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Component
public class Task1 {

    @Scheduled(fixedRate = 3000)
    public void task1() throws InterruptedException {
        log.debug("task111 fixedRate now#{}", LocalDateTime.now());
        Random random = new Random();
        int i = random.nextInt(10);
        Thread.sleep(i * 1000);
    }

}

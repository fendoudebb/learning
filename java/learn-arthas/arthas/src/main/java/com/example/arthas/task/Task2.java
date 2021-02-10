package com.example.arthas.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Task2 {

    @Scheduled(fixedRate = 5000)
    public void task2() {
        log.debug("task222 fixedDelay");
    }

}

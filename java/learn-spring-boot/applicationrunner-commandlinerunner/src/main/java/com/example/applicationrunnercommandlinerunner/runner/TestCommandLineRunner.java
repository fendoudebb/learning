package com.example.applicationrunnercommandlinerunner.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Component
public class TestCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner running, args#" + Arrays.asList(args) + ", threadId#" + Thread.currentThread().getId());

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("CommandLineRunner sub thread, threadId#" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

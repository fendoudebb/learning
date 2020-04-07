package com.example.applicationrunnercommandlinerunner.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(1)
@Component
public class TestApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner running, args#" + Arrays.asList(args.getSourceArgs()));
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("non option args#" + nonOptionArgs);
        List<String> foo = args.getOptionValues("foo");
        System.out.println("option args#" + foo);
        List<String> foo2 = args.getOptionValues("foo2");
        System.out.println("not exist option args#" + foo2);
        Thread.sleep(5000);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("ApplicationRunner sub thread, threadId#" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

package util;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    int sleepSecond = ThreadLocalRandom.current().nextInt(5);
                    System.out.println(LocalDateTime.now() + ": Thread=" + Thread.currentThread().getId() + ", begin sleep, second=" + sleepSecond);
                    TimeUnit.SECONDS.sleep(sleepSecond);
                    System.out.println(LocalDateTime.now() + ": Thread=" + Thread.currentThread().getId() + ", begin end, second=" + sleepSecond);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println(LocalDateTime.now() + ": await begin");
        countDownLatch.await();
        System.out.println(LocalDateTime.now() + ": await end");
    }

}

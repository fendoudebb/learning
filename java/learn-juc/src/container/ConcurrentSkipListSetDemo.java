package container;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/3/28 21:37.
 * 并发 TreeSet
 */
public class ConcurrentSkipListSetDemo {

    private static ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(String.valueOf(ThreadLocalRandom.current().nextInt(10000)));
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(set.toString());

    }

}

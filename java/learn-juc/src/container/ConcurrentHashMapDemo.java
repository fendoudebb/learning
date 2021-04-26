package container;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/3/28 21:46.
 */
public class ConcurrentHashMapDemo {

    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(ThreadLocalRandom.current().nextInt(100000), finalI);
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        System.out.println(map.toString());
    }

}

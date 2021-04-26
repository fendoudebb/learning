package container;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/3/28 21:33.
 * 并发 TreeMap
 */
public class ConcurrentSkipListMapDemo {

    private static ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();

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

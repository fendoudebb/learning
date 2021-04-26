package container;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/3/28 21:43.
 * 并发 HashSet
 */
public class CopyOnWriteArraySetDemo {

    private static CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(String.valueOf(ThreadLocalRandom.current().nextInt(100000)));
            }).start();
        }
        new Thread(() -> {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                System.out.println(next);
                if (Integer.parseInt(next) % 2 == 0) {
                    set.remove(next);
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(set.toString());
    }

}

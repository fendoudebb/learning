package container;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/3/28 21:41.
 * 并发 ArrayList
 */
public class CopyOnWriteArrayListDemo {

    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(ThreadLocalRandom.current().nextInt(10000));
            }).start();
        }
        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                System.out.println(next);
                if (next % 2 == 0) {
                    list.remove(next);
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(list.toString());

    }

}

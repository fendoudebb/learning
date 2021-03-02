package atomic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNotSafeMapDemo {


    public static void main(String[] args) {
//        Map<Integer,String> map = new HashMap<>(); // java.util.ConcurrentModificationException
//        Map<Integer,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<Integer,String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(finalI, UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }).start();
        }
    }

    // java.util.ConcurrentModificationException

}

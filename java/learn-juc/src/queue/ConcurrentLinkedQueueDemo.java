package queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * zbj: created on 2021/3/27 11:57.
 */
public class ConcurrentLinkedQueueDemo {


    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("abc");
        queue.size();
    }

}

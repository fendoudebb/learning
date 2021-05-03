package queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * zbj: created on 2021/4/12 20:59.
 */
public class ConcurrentLinkedDequeDemo {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("b");
        deque.addFirst("a");
        deque.addLast("c");
        deque.size();
    }

}

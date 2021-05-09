package queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * zbj: created on 2021/4/12 20:50.
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.add("b");
        priorityBlockingQueue.add("a");
        priorityBlockingQueue.add("c");
        System.out.println(priorityBlockingQueue.size());

    }

}

package queue;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/3/28 19:55.
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        addAndRemove();

//        offerAndPoll();

//        putAndTake();

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(LocalDateTime.now() + "#" + queue.offer("aaa", 2L, TimeUnit.SECONDS));
        System.out.println(LocalDateTime.now() + "#" + queue.offer("bbb", 2L, TimeUnit.SECONDS));
        System.out.println(LocalDateTime.now() + "#" + queue.offer("ccc", 2L, TimeUnit.SECONDS));
        System.out.println(LocalDateTime.now() + "#" + queue.offer("ddd", 2L, TimeUnit.SECONDS));

        System.out.println(LocalDateTime.now() + "#" + queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(LocalDateTime.now() + "#" + queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(LocalDateTime.now() + "#" + queue.poll(2L, TimeUnit.SECONDS));
        System.out.println(LocalDateTime.now() + "#" + queue.poll(2L, TimeUnit.SECONDS));

    }

    private static void putAndTake() throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("aaa");
        queue.put("bbb");
        queue.put("ccc");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    private static void offerAndPoll() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("aaa"));
        System.out.println(queue.offer("bbb"));
        System.out.println(queue.offer("ccc"));
        System.out.println(queue.offer("ddd"));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void addAndRemove() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("aaa"));
        System.out.println(queue.add("bbb"));
        System.out.println(queue.add("ccc"));

        try {
            queue.add("ddd");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(queue.size());
        System.out.println(queue.remainingCapacity());

        System.out.println(queue.remove("bbb"));
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        try {
            queue.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

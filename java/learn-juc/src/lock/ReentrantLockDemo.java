package lock;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * zbj: created on 2021/2/27 22:19.
 */
public class ReentrantLockDemo {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            // 加几次放几次
            lock.lock();

            try {
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "----------外层");
                lock.lock();
                try {
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "---------内层");
                } finally {
                    lock.unlock();
                }
            } finally {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "----------外层");
                lock.lock();
                try {
                    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + "---------内层");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();

            }
        }, "t2").start();
    }

}

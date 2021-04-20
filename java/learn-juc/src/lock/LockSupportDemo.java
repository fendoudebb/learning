package lock;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * zbj: created on 2021/2/28 13:21.
 */
public class LockSupportDemo {

    public static void main(String[] args) {
//        synchronizedWaitNotify();
//        lockAwaitSignalDemo();

        Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalDateTime.now() + Thread.currentThread().getName() + "\tcome in");
            LockSupport.park();//被阻塞，等待通知
            LockSupport.park();//被阻塞，等待通知
            System.out.println(LocalDateTime.now() + Thread.currentThread().getName() + "\t 被唤醒");
        }, "AAA");
        threadA.start();



        new Thread(() -> {
            LockSupport.unpark(threadA);
            LockSupport.unpark(threadA);
            System.out.println(LocalDateTime.now() + Thread.currentThread().getName() + "\t 发出通知");
        }, "BBB").start();

        LockSupport.park();
    }



    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    private static void lockAwaitSignalDemo() {
        new Thread(() -> {
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t 被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "AAA").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t 唤醒通知");
            } finally {
                lock.unlock();
            }
        }, "BBB").start();
    }


    static final Object objectLock = new Object();

    // java.lang.IllegalMonitorStateException
    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "---------\t come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "---------\t 被唤醒");
            }
        }, "AAA").start();

        new Thread(() -> {
//            synchronized (LockSupportDemo.class) {
            synchronized (objectLock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                objectLock.notify();
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t ---------唤醒通知");

            }
        }, "BBB").start();
    }

}

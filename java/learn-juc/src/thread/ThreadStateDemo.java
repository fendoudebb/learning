package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {

        });
        System.out.println("thread1 state#" + thread1.getState().name());

        Thread thread2 = new Thread(() -> { });
        thread2.start();
        System.out.println("thread2 state#" + thread2.getState().name());

        Thread thread3 = new Thread(() -> { });
        thread3.start();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("thread3 state#" + thread3.getState().name());

        Thread thread4 = new Thread(() -> {
//            synchronized (Object.class) {
                LockSupport.parkNanos(1000*1000*1000);
//            }
        });
        thread4.start();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("thread4 state#" + thread4.getState().name());

        Thread thread5 = new Thread(LockSupport::park);
        thread5.start();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("thread5 state#" + thread5.getState().name());
        LockSupport.unpark(thread5);
//        TimeUnit.MILLISECONDS.sleep(10);
//        System.out.println("thread5 state#" + thread5.getState().name());

        Thread thread6 = new Thread(() -> {
            synchronized (Object.class) {

            }
        });
        thread6.start();
        synchronized (Object.class) {
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("thread6 state#" + thread6.getState().name());
        }

    }
}

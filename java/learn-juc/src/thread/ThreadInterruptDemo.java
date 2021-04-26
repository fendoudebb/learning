package thread;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/4/11 11:13.
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread.onSpinWait();
        Thread thread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(LocalDateTime.now() + " this is thread beginning..." + currentThread.getState());
            currentThread.interrupt();
            System.out.println("isInterrupted1 = " + currentThread.isInterrupted());
            System.out.println("isInterrupted2 = " + currentThread.isInterrupted());
            System.out.println("interrupted1 = " + Thread.interrupted());
            System.out.println("interrupted2 = " + Thread.interrupted());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " this is thread ending..." + currentThread.getState());
        });
        thread.start();
    }

    public static void main2(String[] args) throws InterruptedException {
        Thread.onSpinWait();
        Thread thread = new Thread(() -> {
            System.out.println(LocalDateTime.now() + " this is thread beginning..." + Thread.currentThread().getState());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " this is thread ending..." + Thread.currentThread().getState());
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

}

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
//        method1();
        method2();

    }

    public static void method1() {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(LocalDateTime.now() + ": 当前线程=" + Thread.currentThread().getName() + ", 准备获取锁");
                    semaphore.acquire();
                    System.out.println(LocalDateTime.now() + ": 当前线程=" + Thread.currentThread().getName() + ", 已获得锁, 进行操作");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                    System.out.println(LocalDateTime.now() + ": 当前线程=" + Thread.currentThread().getName() + ", 操作完毕, 释放锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void method2() {
        Semaphore semaphore = new Semaphore(3, true);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(LocalDateTime.now() + ": 当前线程=" + Thread.currentThread().getName() + ", 准备取钱操作");
                    semaphore.acquire();
                    System.out.println(LocalDateTime.now() + ": 当前线程=" + Thread.currentThread().getName() + ", 进入ATM间, 锁门, 取钱");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                    System.out.println(LocalDateTime.now() + ": 当前线程=" + Thread.currentThread().getName() + ", 取完钱了, 开门, 走出ATM");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

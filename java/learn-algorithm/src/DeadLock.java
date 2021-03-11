import java.util.concurrent.TimeUnit;

public class DeadLock {

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (DeadLock.class) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Object.class) {
                    System.out.println("Thread 1");
                }
            }
        },"A").start();

        new Thread(() -> {
            synchronized (Object.class) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLock.class) {
                    System.out.println("Thread 2");
                }

            }
        },"B").start();
    }

}

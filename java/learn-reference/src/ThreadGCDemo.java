import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class ThreadGCDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            /*while (true) {
                try {
                    System.out.println("5555555555555555");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            LockSupport.park();
        });
        thread.start();

        WeakReference<Thread> reference = new WeakReference<>(thread);
        thread = null;
        System.gc();
        while (true) {
            TimeUnit.SECONDS.sleep(5);

            System.out.println(thread);
            System.out.println(reference.get());
        }
//        LockSupport.park();
    }

}

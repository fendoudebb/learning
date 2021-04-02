import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class WeakReferenceDemo {
    public static void main(String[] args) {

        Object obj1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj1);
        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in weak reference=" + weakReference.get());
        System.out.println("weak reference=" + weakReference);


        obj1 = null;
        System.gc();

        System.out.println("------------ After GC ------------");

        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in weak reference=" + weakReference.get());
        System.out.println("weak reference=" + weakReference);

        System.out.println("***********************************************");

        Thread thread1 = new Thread(() -> {
            System.out.println("111111111");
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("22222222222");
            }
        });
        thread1.start();

        WeakReference<Thread> wr = new WeakReference<>(thread1);

        thread1 = null;
        System.gc();

        System.out.println("------------ After GC ------------");

        System.out.println("weak reference=" + wr.get());

        LockSupport.park();
    }
}

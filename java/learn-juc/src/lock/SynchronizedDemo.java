package lock;

import org.openjdk.jol.info.ClassLayout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

// -XX:+UseBiasedLocking,启动默认五秒之后生效。可以立即生效：-XX:BiasedLockingStartupDelay=0
// 禁用偏向锁 -XX:-UseBiasedLocking
// -XX:-UseCompressedClassPointers
public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {

//        biasedLock();

//        lightweightLock();

//        heavyweightLock();

//        classLayout();

//        LockCoarsening
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(123);
        stringBuffer.append(456);
        stringBuffer.append(789);
        System.out.println(stringBuffer);


        LockSupport.park();
    }

    public static void classLayout() {
        Object obj = new Object();
        System.out.println("obj hashcodeHex#" + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("----------------------------------------------------------");

        int[] arr = new int[10];
        System.out.println("arr hashcodeHex#" + Integer.toHexString(Arrays.hashCode(arr)));
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }

    public static void biasedLock() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("开始演示...");

        Object lock1 = new Object() {
            @Override
            public int hashCode() {
                return 123456;
            }
        };
        Object lock2 = new Object();
        Object lock3 = new Object();

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("lock1 Thread id#" + Thread.currentThread().getId() + ", hashCode#" + Thread.currentThread().hashCode() + ", hashCodeHex#" + Integer.toHexString(Thread.currentThread().hashCode()));
                System.out.println(ClassLayout.parseInstance(lock1).toPrintable() + "\n##########################################");
            }
        }, "A").start();

        /*new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lock1) {
                System.out.println("lock1' Thread id#" + Thread.currentThread().getId() + ", hashCode#" + Thread.currentThread().hashCode() + ", hashCodeHex#" + Integer.toHexString(Thread.currentThread().hashCode()));
                System.out.println(ClassLayout.parseInstance(lock1).toPrintable() + "\n##########################################");
            }
        }, "A'").start();*/

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("lock2 hashcodeHex#" + Integer.toHexString(lock2.hashCode()));
                System.out.println(ClassLayout.parseInstance(lock2).toPrintable() + "\n------------------------------------------");
            }
        }, "B").start();

        System.out.println("lock3 hashcodeHex#" + Integer.toHexString(lock3.hashCode()));
        new Thread(() -> {
            synchronized (lock3) {
                System.out.println(ClassLayout.parseInstance(lock3).toPrintable() + "\n******************************************");
            }
        }, "C").start();
    }

    public static void heavyweightLock() {
        Object lock = new Object();
        System.out.println("Thread id#" + Thread.currentThread().getId());
        System.out.println("lock hashcode#" + Integer.toHexString(lock.hashCode()));
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        System.out.println("----------------------------------------------");

        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
                System.out.println("##########################################");
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        }).start();
    }

    public static void lightweightLock() {
        Object lock = new Object();
        System.out.println("Thread id#" + Thread.currentThread().getId());
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        System.out.println("----------------------------------------------");

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable() + "\n##########################################");
            }
        }, "A").start();

        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable() + "\n##########################################");
            }
        }, "B").start();

        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable() + "\n##########################################");
            }
        }, "C").start();

        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lock) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable() + "\n++++++++++++++++++++++++++++++++++++++++++");
            }
        }, "D").start();
    }

}

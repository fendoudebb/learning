package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class ThreadLocalDemo {


    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        fixedThreadPool.execute(() -> {
            Thread thread = Thread.currentThread();
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            try {
                threadLocal.set(thread.getName());
            } finally {
//                threadLocal.remove();
            }
            threadLocal = null;
            System.gc();

            ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

            Object o = threadLocal2.get();

            threadLocal2 = null;
            System.gc();
        });

        fixedThreadPool.execute(() -> {
            Thread thread = Thread.currentThread();
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            try {
                threadLocal.set(thread.getName());
            } finally {
                threadLocal.remove();
            }
            threadLocal = null;
            System.gc();
        });

        new Thread(() -> {
            Thread thread = Thread.currentThread();
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            try {
                threadLocal.set(thread.getName());
            } finally {
//                threadLocal.remove();
            }

            threadLocal = null;
            System.gc();

            ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();
            try {
                threadLocal2.set(thread.getName());
            } finally {
                threadLocal2.remove();
            }
            threadLocal2 = null;
            System.gc();
        },"AAA").start();
        LockSupport.park();
    }

}

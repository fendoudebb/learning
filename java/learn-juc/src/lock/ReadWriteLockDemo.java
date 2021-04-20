package lock;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * zbj: created on 2021/2/28 14:55.
 * 读写锁
 * <p>
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {

            int finalI = i;
            new Thread(() -> {
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                myCache.put(finalI +"", finalI +"");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(finalI +"");
            }, String.valueOf(i)).start();
        }
    }


    private static class MyCache {

        private volatile Map<String, Object> map = new HashMap<>();
        private ReadWriteLock lock = new ReentrantReadWriteLock();

        public void put(String key, String value) {
            lock.writeLock().lock();
            try {
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t正在写入：" + key);
                // 模拟网络延迟
                try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
                map.put(key, value);
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t写入完成：" + key);
            } finally {
                lock.writeLock().unlock();
            }
        }

        public void get(String key) {
            lock.readLock().lock();
            try {
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t正在读取：" + key);
                // 模拟网络延迟
               /* try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                Object result = map.get(key);
                System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t读取完成：" + key + "-" + result);
            } finally {
                lock.readLock().unlock();
            }
        }


    }

}

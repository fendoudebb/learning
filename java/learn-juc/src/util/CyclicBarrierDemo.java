package util;

import java.time.LocalDateTime;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+" 开始CyclicBarrier");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,() -> {
            System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", 完成所有接口请求, 合并数据---开始");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", 完成所有接口请求, 合并数据---结束");
        });
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", 模拟请求API-1, 耗时2秒, 完成, 等待其他接口返回");
                cyclicBarrier.await();
                System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", CyclicBarrier释放了, API-1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", 模拟请求API-2, 耗时4秒, 完成, 等待其他接口返回");
                cyclicBarrier.await();
                System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", CyclicBarrier释放了, API-2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", 模拟请求API-3, 耗时3秒, 完成, 等待其他接口返回");
                cyclicBarrier.await();
                System.out.println(LocalDateTime.now() + ": ThreadId: " + Thread.currentThread().getId()+", CyclicBarrier释放了, API-3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

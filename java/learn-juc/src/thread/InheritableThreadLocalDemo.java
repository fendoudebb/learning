package thread;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/4/12 10:31.
 */
public class InheritableThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
//        method();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("abc");
        new Thread(() -> {
            System.out.println(inheritableThreadLocal.get());
        }, "child").start();
    }

    private static void method() throws InterruptedException {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        new Thread(() -> {
            System.out.println(LocalDateTime.now() + " 子线程初始化完成");

            new Thread(() -> {
                System.out.println(LocalDateTime.now() + " 孙线程初始化完成");
                try {
                    TimeUnit.MILLISECONDS.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + " 孙线程sleep完成");
                String s2 = inheritableThreadLocal.get();
                System.out.println(LocalDateTime.now() + " 孙线程获取的数据#" + s2);
            }).start();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " 子线程sleep完成");
            String s = inheritableThreadLocal.get();
            System.out.println(LocalDateTime.now() + " 子线程获取的数据#" + s);


        }).start();

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(LocalDateTime.now() + " 主线程设置value");

        inheritableThreadLocal.set("abc");
    }

}

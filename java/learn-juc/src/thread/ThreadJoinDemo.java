package thread;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ThreadJoinDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(LocalDateTime.now() + " t1 is running, group#" + Thread.currentThread().getThreadGroup());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + " t1 run over, group#" + Thread.currentThread().getThreadGroup());
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                //t1调用join方法, t2会等待t1运行完之后才会开始执行后续代码
                t1.join();
				System.out.println(LocalDateTime.now() + " t2 is running, group#" + Thread.currentThread().getThreadGroup());
				TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
			try {
				//t2调用join方法, t3会等待t2运行完之后才会开始执行后续代码
				t2.join();
				System.out.println(LocalDateTime.now() + " t3 is running, group#" + Thread.currentThread().getThreadGroup());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t3");

        //依次启动3个线程
        t1.start();
        t2.start();
        t3.start();
        LockSupport.park();
    }
}

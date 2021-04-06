package lock;

import java.util.concurrent.locks.LockSupport;

public class LockCoarseningDemo {

    public void test() {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("11111111");
        }
        synchronized (lock) {
            System.out.println("22222222");
        }
        synchronized (lock) {
            System.out.println("33333333");
        }
    }

    public static void main(String[] args) {
        LockCoarseningDemo lockCoarseningDemo = new LockCoarseningDemo();
        lockCoarseningDemo.test();
        LockSupport.park();
    }

}

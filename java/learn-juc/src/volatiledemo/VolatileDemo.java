package volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * zbj: created on 2021/2/25 22:13.
 */
public class VolatileDemo {

    static volatile int number;

    static int number2;

    public static AtomicInteger atomicInteger = new AtomicInteger();

    static class MyData0 {
        int number;
        public void addTo60() {
            number = 60;
        }
    }

    static class MyData1 {
        volatile int number;
        public void addTo60() {
            number = 60;
        }
    }

    public static void main(String[] args) {
//        MyData0 myData0 = new MyData0();
        MyData1 myData1 = new MyData1();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            myData0.addTo60();
            myData1.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update over");

        }).start();

        while (myData1.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\tmission is over");

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    number++;
                    number2++;
                    atomicInteger.getAndIncrement();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(number);
        System.out.println(number2);
        System.out.println(atomicInteger.get());

    }

}

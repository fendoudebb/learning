package atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    int number;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2021)+"\tcurrent data#" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020)+"\tcurrent data#" + atomicInteger.get());

        atomicInteger.getAndIncrement();


        new Thread(()->{
//            Unsafe unsafe = Unsafe.getUnsafe();
            Unsafe unsafe = getUnsafe();
            long number = 0;
            try {
                number = unsafe.objectFieldOffset(AtomicIntegerDemo.class.getDeclaredField("number"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            System.out.println(number);
        }).start();
    }

    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe)field.get(null);

        } catch (Exception e) {
        }
        return null;
    }

}

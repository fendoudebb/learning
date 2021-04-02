import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static void memoryEnough() {
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in soft reference=" + softReference.get());
        System.out.println("soft reference=" + softReference);

        obj1 = null;
        System.gc();

        System.out.println("------------ Memory Enough After GC ------------");

        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in soft reference=" + softReference.get());
        System.out.println("soft reference=" + softReference);

    }

    // -Xms5m -Xmx5m
    public static void memoryNotEnough() {
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in soft reference=" + softReference.get());
        System.out.println("soft reference=" + softReference);

        obj1 = null;

        System.out.println("------------ Memory Not Enough OOM ------------");

        try {
            byte[] bytes = new byte[30 * 1024 * 1024]; // 30MB 内存
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("obj1=" + obj1);
            System.out.println("obj1 in soft reference=" + softReference.get());
            System.out.println("soft reference=" + softReference);
        }
    }

    public static void main(String[] args) {
//        memoryEnough();
        memoryNotEnough();
    }

}

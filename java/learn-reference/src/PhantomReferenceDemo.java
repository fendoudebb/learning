import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj1, referenceQueue);

        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in phantom reference=" + phantomReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("phantom reference=" + phantomReference);

        System.out.println("-----------------------------------");

        obj1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println("obj1=" + obj1);
        System.out.println("obj1 in phantom reference=" + phantomReference.get());
        Reference<?> pollReference = referenceQueue.poll();
        System.out.println(pollReference);
        System.out.println("phantom reference=" + phantomReference);

        if (pollReference != null) {
            try {
                Field rereferent = Reference.class.getDeclaredField("referent");
                rereferent.setAccessible(true);
                Object result = rereferent.get(pollReference);
                System.out.println("gc will collect#" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

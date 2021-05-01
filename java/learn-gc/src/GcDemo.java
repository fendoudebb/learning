import java.util.Random;

/**
 * zbj: created on 2021/2/28 9:27.
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC          DefNew+Tenured
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC          ParNew+Tenured
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC          PSYoungGen+ParOldGen
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC          par new generation+concurrent mark-sweep generation
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC          PSYoungGen+ParOldGen
 *
 */
public class GcDemo {

    public static void main(String[] args) {
        System.out.println("*******************hello gc");

        try {
            String str = "";
            while (true) {
                str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

import java.util.concurrent.locks.LockSupport;

/**
 * zbj: created on 2021/7/4 17:57.
 * -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:-EliminateAllocations -XX:+PrintGCDetails
 * -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+EliminateAllocations -XX:+PrintGCDetails
 */
public class ScalarReplaceDemo {

    public static void main(String[] args) throws InterruptedException {
        long startTs = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        System.out.println("cost time# " + (System.currentTimeMillis() - startTs) + "ms");
        LockSupport.park();
    }

    public static void alloc() {
        User user = new User();
        user.id = 1;
        user.age = 10;
    }

    static class User {
        int id;
        int age;
    }

}

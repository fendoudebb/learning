import java.util.concurrent.locks.LockSupport;

/**
 * zbj: created on 2021/7/4 17:57.
 *
 * 不要以 debug 模式启动
 *
 * 关闭逃逸分析
 * -Xms256m -Xmx256m -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 *
 * 关闭逃逸分析
 * -Xms2g -Xmx2g -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 *
 * 开启逃逸分析，默认开启
 * -Xms2g -Xmx2g -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 *
 * -XX:+PrintEscapeAnalysis
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 * Error: VM option 'PrintEscapeAnalysis' is notproduct and is available only in debug version of VM.
 */
public class StackAllocationDemo {

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

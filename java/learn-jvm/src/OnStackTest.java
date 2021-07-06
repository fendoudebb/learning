import java.util.concurrent.locks.LockSupport;

public class OnStackTest {
    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "test";
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start visual vm...");
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        System.out.println("loop end...");
        long e = System.currentTimeMillis();
        System.out.println(e - b);
        LockSupport.park();
    }
}

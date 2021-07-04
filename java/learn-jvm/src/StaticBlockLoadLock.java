import java.util.concurrent.locks.LockSupport;

public class StaticBlockLoadLock {
    static {
        System.out.println(Thread.currentThread().getName() + "#test static block");
        LockSupport.park();
    }

    public StaticBlockLoadLock() {
        System.out.println(Thread.currentThread().getName() + "#test constructor");
        LockSupport.park();
    }
}

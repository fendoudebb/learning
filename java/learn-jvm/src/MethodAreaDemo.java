import java.util.concurrent.locks.LockSupport;

/**
 * Java7
 * -XX:PermSize=100m -XX:MaxPermSize=100m
 *
 * Java8
 * Windows 平台 默认大小 -XX:MetaspaceSize=21807104 约等于 20.8m -XX:MaxMetaspaceSize=18446744073709486080 约等于
 * -XX:MetaspaceSize=100m -XX:MaxMetaspaceSize=100m
 *
 * MetaspaceSize 建议设置一个较高的值
 */
public class MethodAreaDemo {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        LockSupport.park();
    }

}

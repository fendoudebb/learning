import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * zbj: created on 2021/7/15 20:34.
 */
public class OQLDemo {

    public static Map<String, String> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            // 当 Queue 满了时 且还pool size还未满maxPoolSize，则会立即创建新线程去处理新达到的任务（不是Queue中的任务）
            5,
            // 多余的空闲的线程存活的时间，maxPoolSize减去corePoolSize个线程受此参数影响（corePoolSize常驻不受keepalive影响）
            100L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3),
            // 默认即可
            Executors.defaultThreadFactory(),
            // 队列满了，且正在运行的线程数量大于或等于maxPoolSize，会启动饱和拒绝策略
            new ThreadPoolExecutor.CallerRunsPolicy());

    static {
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, "value" + i);
            list.add("list" + i);
            int finalI = i;
            executor.execute(() -> {
                String s = "this is executor" + finalI;
                new OQLDemo();
                LockSupport.park();
            });
        }
    }

    public String abc = "xxx";

    public static void main(String[] args) {
        LockSupport.park();

    }

}

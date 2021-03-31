package future;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    private static final Map<String, String> CACHE_NORMAL = new ConcurrentHashMap<>();
    private static final Map<String, FutureTask<String>> CACHE_FUTURE_TASK = new ConcurrentHashMap<>();

    public static String getNormal(String key) {
        String value = CACHE_NORMAL.get(key);
        if (value == null) {
//            value = getFromDB(key);
            CACHE_NORMAL.putIfAbsent(key, value);
        }
        return value;
    }

    public String getByFutureTask(String key) {
        String value = CACHE_NORMAL.get(key);
        if (value == null) {
            System.out.println("step 1#缓存中无数据");
            FutureTask<String> futureTask = CACHE_FUTURE_TASK.get(key);
            if (futureTask == null) {
                FutureTask<String> ft = new FutureTask<>(() -> {
                    System.out.println("step 1.1#请求资源并缓存");
                    String v = getFromDB(key);
                    CACHE_NORMAL.putIfAbsent(key, v);
                    return v;
                });
                futureTask = CACHE_FUTURE_TASK.putIfAbsent(key, ft);
                if (futureTask == null) {
                    System.out.println("step 1.2#无缓存任务运行, 开始执行");
                    futureTask = ft;
                    futureTask.run();
                }
            } else {
                System.out.println("step 1.3#任务已经在缓存中，再运行了");
            }
            try {
                String s = futureTask.get();
                System.out.println("step 1.4#从 future task get#" + s);
                return s;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                CACHE_FUTURE_TASK.remove(key, futureTask);
            }
        } else {
            System.out.println("step 2#缓存中有数据，直接返回");
            return value;
        }

    }

    protected String getFromDB(String key) {
        System.out.println("get from db#" + LocalDateTime.now() + ", thread id#" + Thread.currentThread().getId());
        return LocalDateTime.now() + " " + key;
    }

    public static void main(String[] args) {
        FutureTaskDemo futureTaskDemo = new FutureTaskDemo();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                futureTaskDemo.getByFutureTask("test");
            }).start();
        }
    }

}

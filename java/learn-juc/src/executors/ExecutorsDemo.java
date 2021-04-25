package executors;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * zbj: created on 2021/2/26 22:12.
 */
public class ExecutorsDemo {

    public static void main(String[] args) {
        // 使用目前机器上可用的处理器作为它的并行级别
//        Executors.newWorkStealingPool()

        // maxPoolSize
        // CPU密集：for each，IO密集：数据库交互，写磁盘
        // CPU密集型：CPU核数+1，
        // IO密集型：不是一直执行任务的情况下，CPU核数 * 2
        // IO密集型：大量的阻塞，CPU核数/(1-阻塞系数)，阻塞系数在（0.8~0.9之间）。比如8核：8/(1-0.9) = 80 个线程数

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
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
                // AbortPolicy：拒绝策略，抛异常；CallerRunsPolicy：调用者线程处理；DiscardPolicy：丢弃；DiscardOldestPolicy：丢弃最早的（队列中的最早的）
        // 线程池所有任务完成后会收缩到corePoolSize
        try {
            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                executor.execute(() -> {
                    System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "---#" + finalI + " --- executor#" + executor.toString());
                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executor.shutdown();
        }


    }

}

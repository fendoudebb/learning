package learn.spring.boot.schedule;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduleTask {

    /*@Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct init");
        exec.scheduleAtFixedRate(() -> {
            long startTime = System.currentTimeMillis();
            ThreadPoolExecutor threadPoolExecutor = threadPoolTaskScheduler.getScheduledThreadPoolExecutor();

            //线程池需要执行的任务数
            long taskCount = threadPoolExecutor.getTaskCount();

            //线程池在运行过程中已完成的任务数
            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();

            //线程池里活跃的线程数量
            long activeCount = threadPoolExecutor.getActiveCount();

            //线程池里的线程数量
            long poolSize = threadPoolExecutor.getPoolSize();

            int corePoolSize = threadPoolExecutor.getCorePoolSize();

            int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();

            //曾经创建过的最大线程数
            long largestPoolSize = threadPoolExecutor.getLargestPoolSize();

            int queueSize = threadPoolExecutor.getQueue().size();

            int queueRemainingCapacity = threadPoolExecutor.getQueue().remainingCapacity();

            long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);

            boolean isShutdown = threadPoolExecutor.isShutdown();
            boolean isTerminated = threadPoolExecutor.isTerminated();
            boolean isTerminating = threadPoolExecutor.isTerminating();

//            System.out.println(LocalDateTime.now() + "#async-executor monitor channel send thread ThreadPoolExecutor - " + threadPoolExecutor.toString());

            long endTime = System.currentTimeMillis();

            System.out.println(LocalDateTime.now() + "#async-executor monitor channel send thread stats info. " +
                    "taskCount[" + taskCount + "], " +
                    "completedTaskCount[" + completedTaskCount + "], " +
                    "activeCount[" + activeCount + "], " +
                    "poolSize[" + poolSize + "], " +
                    "corePoolSize[" + corePoolSize + "], " +
                    "maximumPoolSize[" + maximumPoolSize + "], " +
                    "largestPoolSize[" + largestPoolSize + "], " +
                    "queueSize[" + queueSize + "], " +
                    "queueRemainingCapacity[" + queueRemainingCapacity + "], " +
                    "keepAliveTime[" + keepAliveTime + "], " +
                    "isShutdown[" + isShutdown + "], " +
                    "isTerminated[" + isTerminated + "], " +
                    "isTerminating[" + isTerminating + "], " +
                    "monitorCostTime[" + (endTime - startTime) + "]");
        }, 1, 1, TimeUnit.SECONDS);
    }*/

    @Scheduled(cron = "*/1 * * * * *")
    public void cronTask() throws InterruptedException {
        int i = Thread.activeCount();
        System.out.println("active count#" + i);
//        Thread.currentThread().
        System.out.println(LocalDateTime.now() + "-[" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + "]#cron task execute!");
        Thread.sleep(50000);
        new Thread(() -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void fixedDelayTask() throws InterruptedException {
        System.out.println(LocalDateTime.now() + "-[" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + "]#fixed delay task execute!");
        Thread.sleep(50000);
        new Thread(() -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Scheduled(fixedRate = 1000, initialDelay = 1000)
    public void fixedRateTask() throws InterruptedException {
        System.out.println(LocalDateTime.now() + "-[" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + "]#fixed rate task execute!");
        Thread.sleep(50000);
        new Thread(() -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


}

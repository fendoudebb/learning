package learn.spring.boot.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.LocalDateTime;
import java.util.concurrent.*;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    private ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(20);
        threadPoolTaskScheduler.setThreadGroupName("task-scheduler");
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
        return threadPoolTaskScheduler;
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        threadPoolTaskScheduler.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("111111");

            }
        });
        return threadPoolTaskScheduler;
    }

}

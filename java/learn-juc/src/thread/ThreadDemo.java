package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ThreadDemo {

    // -Xmx5m -Xss1024k
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, NoSuchFieldException {

        getAllThreads();

    }

    private static void daemonThread() {
        Thread thread1 = new Thread(() -> {
            System.out.println("111111111");
        });
        thread1.setDaemon(true);
        thread1.start();
    }

    public static void getAllThreads() {
        Thread.getAllStackTraces().forEach((thread, stackTraceElements) -> {
            System.out.println(thread.getName());
        });
    }

    public static void getAllThreadsByReflect() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class<Thread> threadClass = Thread.class;
        Method getThreads = threadClass.getDeclaredMethod("getThreads");
        getThreads.setAccessible(true);
        Thread thread = threadClass.newInstance();
        Thread[] threads = (Thread[]) getThreads.invoke(thread);
        for (Thread t : threads) {
            System.out.println("id#" + t.getId() + ", name#" + t.getName() + ", isAlive#" + t.isAlive() + ", isDaemon#" + t.isDaemon() + ", threadGroup#" + t.getThreadGroup().getName() + ", priority#" + t.getPriority() + ", activeCount#" + t.getThreadGroup().activeCount());
        }

        Field stackSize = threadClass.getDeclaredField("stackSize");
        stackSize.setAccessible(true);
        long aLong = stackSize.getLong(thread);
        System.out.println(aLong);
    }

    public static String crunchifyGenerateThreadDump() {
        final StringBuilder dump = new StringBuilder();
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
        for (ThreadInfo threadInfo : threadInfos) {
            dump.append('"');
            dump.append(threadInfo.getThreadName());
            dump.append("\" ");
            final Thread.State state = threadInfo.getThreadState();
            dump.append("\n   java.lang.Thread.State: ");
            dump.append(state);
            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
            for (final StackTraceElement stackTraceElement : stackTraceElements) {
                dump.append("\n        at ");
                dump.append(stackTraceElement);
            }
            dump.append("\n\n");
        }
        return dump.toString();
    }

}

package queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * zbj: created on 2021/4/12 21:02.
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        DelayQueue<DelayMessage> delayQueue = new DelayQueue<>();
    }

    private static class DelayMessage implements Delayed {

        private final long delayTime; // 延迟时间
        private final long expire; // 到期时间

        private String data;


        public DelayMessage(long delay, String data) {
            this.delayTime = delay;
            this.data = data;
            this.expire = System.currentTimeMillis() + delay;
        }

        // 剩余时间=到期时间-当前时间
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
        }
    }

}

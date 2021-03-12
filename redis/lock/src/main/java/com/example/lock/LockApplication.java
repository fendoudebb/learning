package com.example.lock;

import com.example.lock.util.RedisLock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LockApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LockApplication.class, args);
    }

    @Resource
    private RedisLock redisLock;

    @Override
    public void run(String... args) throws Exception {
        String key = "myLock";
        // 注意 锁同一个对象时，切记设置不同的 value 值，因为 Lua 脚本是根据传入的值与 Redis 中保存的值做比较，相同才执行 delete
        String value = DigestUtils.md5DigestAsHex(String.valueOf(System.currentTimeMillis()).getBytes());
        boolean lock = redisLock.tryLock(key, value, 10, TimeUnit.SECONDS);
        if (lock) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } finally {
                boolean unlock = redisLock.unlock(key, value);
                System.out.println(unlock);
            }
        }
    }
}

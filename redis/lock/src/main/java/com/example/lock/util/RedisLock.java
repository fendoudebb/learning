package com.example.lock.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String UNLOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    private static final Long UNLOCK_SUCCESS_RESULT = 1L;

    public boolean tryLock(String key, String value, long timeout, TimeUnit timeUnit) {
        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent(key, value, timeout, timeUnit);
        return lock != null && lock;
    }

    public boolean unlock(String key, String value) {
        Long result = stringRedisTemplate.execute(RedisScript.of(UNLOCK_LUA_SCRIPT, Long.class), Collections.singletonList(key), value);
        return UNLOCK_SUCCESS_RESULT.equals(result);
    }

}

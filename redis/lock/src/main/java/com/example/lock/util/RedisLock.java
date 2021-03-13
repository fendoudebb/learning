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

/*    public boolean unlockJedis(String key, String value) {
        Long result = stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                Object nativeConnection = connection.getNativeConnection();
                // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                // 集群模式
                if (nativeConnection instanceof JedisCluster) {
                    return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA_SCRIPT, key, value);
                }

                // 单机模式
                else if (nativeConnection instanceof Jedis) {
                    return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA_SCRIPT, key, value);
                }
                return 0L;
            }
        });
        return UNLOCK_SUCCESS_RESULT.equals(result);
    }*/

}

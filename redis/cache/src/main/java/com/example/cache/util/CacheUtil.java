package com.example.cache.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class CacheUtil {

    private static ConcurrentHashMap<String, String> CACHE = new ConcurrentHashMap<>();

    private static final ReentrantLock lock = new ReentrantLock();

    public String getData(String keywords) throws InterruptedException {
        String data = getDataFromCache(keywords);
        if (data == null) {
            if (lock.tryLock()) {
                try {
                    data = getDataFromDB(keywords);
                    saveToCache(keywords, data);
                } finally {
                    lock.unlock();
                }
            } else {
                TimeUnit.SECONDS.sleep(300);
                data = getData(keywords);
            }
        }
        return data;
    }

    public String getData2(String keywords) throws InterruptedException {
        String data = getDataFromCache(keywords);
        if (data == null) {
            int count = 0;
            while (!lock.tryLock()) {
                TimeUnit.SECONDS.sleep(300);
                if (++count >= 5) {
                    return null;
                }
            }
            try {
                data = getDataFromCache(keywords);
                if (data == null) {
                    data = getDataFromDB(keywords);
                    saveToCache(keywords, data);
                }
            } finally {
                lock.unlock();
            }
        }
        return data;
    }

    private String getDataFromCache(String keywords) {
        return CACHE.get(keywords);
    }

    private String getDataFromDB(String keywords) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return null;
    }

    private void saveToCache(String keywords, String data) {
        CACHE.put(keywords, data);
    }

}

package com.example.arthas.controller;

import com.example.arthas.view.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class Test111Controller {

    @Value("${config.maxConn}")
    private Integer maxConn;

    @GetMapping("/test1")
    public Result test1(@RequestParam String key) throws InterruptedException {
        log.info("test1111111111111#{}", key);
        if ("ccc".equals(key)) {
            throw new RuntimeException("custom exception");
        }
        if ("bbb".equals(key)) {
            Thread.sleep(1000);
        }
        key = "ddd";
        List<String> list = (List<String>) CollectionUtils.arrayToList(new String[]{"aaa", "bbb", "ccc", key});
        return Result.builder().msg("success#" + maxConn).data(list).build();
    }

}

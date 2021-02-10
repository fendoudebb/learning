package com.example.arthas.controller;

import com.example.arthas.view.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class Test111Controller {

    @GetMapping("/test1")
    public Result test1(@RequestParam String key) {
        log.info("test1111111111111#{}", key);
        List<String> list = (List<String>) CollectionUtils.arrayToList(new String[]{"aaa", "bbb", "ccc"});
        return Result.builder().msg("请求成功").data(list).build();
    }

}

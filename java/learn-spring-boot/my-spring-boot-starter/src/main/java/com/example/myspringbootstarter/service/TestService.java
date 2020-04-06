package com.example.myspringbootstarter.service;

import com.example.myspringbootstarter.config.TestConfig;

/**
 * zbj: created on 2020/4/6 11:10.
 */

public class TestService {

    private TestConfig testConfig;

    public TestService(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public String say() {
        return testConfig.getCode() + ":" + testConfig.getMsg();
    }
}

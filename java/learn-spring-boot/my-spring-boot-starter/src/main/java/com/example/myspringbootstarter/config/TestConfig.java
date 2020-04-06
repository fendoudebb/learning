package com.example.myspringbootstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * zbj: created on 2020/4/6 11:11.
 */
@Data
@ConfigurationProperties(prefix = "test")
public class TestConfig {

    private Integer code;

    private String msg;

}

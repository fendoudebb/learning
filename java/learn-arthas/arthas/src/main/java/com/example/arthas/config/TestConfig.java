package com.example.arthas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * zbj: created on 2021/2/11 19:09.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class TestConfig {

    private String url;

    private Boolean isTest;

    private Integer maxConn;

}

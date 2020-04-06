package com.example.myspringbootstarter.config;

import com.example.myspringbootstarter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zbj: created on 2020/4/6 11:12.
 */
@Configuration
@ConditionalOnClass(TestService.class)
@EnableConfigurationProperties(TestConfig.class)
public class TestAutoConfiguration {

    @Autowired
    private TestConfig testConfig;

    @Bean
    @ConditionalOnMissingBean(TestService.class)
    public TestService testService() {
        return new TestService(testConfig);
    }
}

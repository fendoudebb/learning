package com.example.arthas.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    // Arthas ognl获取applicationContext
    // ognl '@com.example.arthas.util.SpringContextUtil@applicationContext'
    public static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextUtil.applicationContext == null) {
            SpringContextUtil.applicationContext = applicationContext;
        }
    }

    /*public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }*/
}
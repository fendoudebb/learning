package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    @Resource
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送方
        mainMessage.setFrom("123@test.com");
        //接收方
        mainMessage.setTo("456@test.com");
        //抄送
        mainMessage.setCc("789@test.com");
        //密送
        mainMessage.setBcc("111@test.com");
        //发送的标题
        mainMessage.setSubject("主题2");
        //发送的内容
        mainMessage.setText("内容2");
        javaMailSender.send(mainMessage);
    }
}

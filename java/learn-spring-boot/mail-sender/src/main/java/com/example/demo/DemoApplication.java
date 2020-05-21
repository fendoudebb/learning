package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    @Resource
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        sendSimpleMail();
        sendMimeMessage();
    }

    private void sendMimeMessage() throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("123@test.com");
        mimeMessageHelper.setTo("123@test.com");//此处为调试，发给了自己
        mimeMessageHelper.setSubject("主题3333");

        ClassPathResource classPathResource = new ClassPathResource("application.yml");

        File attachmentFile = classPathResource.getFile();
        mimeMessageHelper.addAttachment(MimeUtility.encodeWord("附件1:application.yml"), attachmentFile);

        ByteArrayDataSource attachmentDataSource = new ByteArrayDataSource(classPathResource.getInputStream(), "application/octet-stream");
        mimeMessageHelper.addAttachment(MimeUtility.encodeText("附件2:application.yml"), attachmentDataSource);
        //富文本
        mimeMessageHelper.setText("<html><body><p>你好:</p><div><img src='cid:contentId1'></div><a href='https://www.baidu.com'>https://www.baidu.com</a></body></html>",true);

        ClassPathResource classPathResource2 = new ClassPathResource("pic/test.png");

        String type = Files.probeContentType(Paths.get(classPathResource2.getURI()));

        ByteArrayDataSource inlineDataSource = new ByteArrayDataSource(classPathResource2.getInputStream(), type);

        mimeMessageHelper.addInline("contentId1", inlineDataSource);
        javaMailSender.send(mimeMessage);
    }

    private void sendSimpleMail() {
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

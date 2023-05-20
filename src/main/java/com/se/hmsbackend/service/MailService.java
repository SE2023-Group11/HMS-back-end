package com.se.hmsbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public String getCheckCode(){
        StringBuilder sb = new StringBuilder();
        Random random=new Random();
        for(int i=1;i<=6;i++) {
            int a=random.nextInt()%10;
            if(a<0)a=-a;
            sb.append(a);
        }
        return sb.toString();
    }
    public void sendMail(String name, String to, String code) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(username);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject("验证码");
        //邮件内容
        message.setText(name+"您好，您正在进行账号注册，验证码为"+code+",切勿将验证码泄露于他人。");
        //发送邮件
        mailSender.send(message);
        log.info("邮件发送成功 "+to);
    }
}

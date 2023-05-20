package com.se.hmsbackend.utils;

import com.se.hmsbackend.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailUtilTest {
    @Autowired
    private MailService mailClient;
    @Test
    public void sendMailTest(){
        String code = MailUtil.getCheckCode();
//        mailClient.sendMail("张三","2604307870@qq.com", "123456");
    }
}

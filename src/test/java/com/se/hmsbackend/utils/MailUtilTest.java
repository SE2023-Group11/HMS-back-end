package com.se.hmsbackend.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailUtilTest {
    @Test
    public void sendMailTest(){
        String code = MailUtil.getCheckCode();
        MailUtil.sendMail("user","2604307870@qq.com",code);
    }
}

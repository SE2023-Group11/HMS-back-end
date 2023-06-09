package com.se.hmsbackend.utils;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

@Slf4j
public class MailUtil {
//    public static String myEmailAccount = "board_checkcode@126.com";
//    public static String myEmailPassword = "HMUGRDPERXPOCJDH";//授权密码1
//    授权密码2：LXSYZIWVTHVTZIQK
//    邮箱密码： TdBuBrUwfbiw4Tu
//    163授权密码： HHCOSUKAWRSNRJZT
//    public static String myEmailSMTPHost = "smtp.126.com";

    public static String myEmailAccount = "EmailUtil2023@163.com";
    public static String myEmailPassword = "HHCOSUKAWRSNRJZT";
    public static String myEmailSMTPHost = "smtp.163.com";
    public static String receiveMailAccount = "";

    public static String getCheckCode(){
        StringBuilder sb = new StringBuilder();
        Random random=new Random();
        for(int i=1;i<=6;i++) {
            int a=random.nextInt()%10;
            if(a<0)a=-a;
            sb.append(a);
        }
        return sb.toString();
    }
    public static boolean sendMail(String username,String mail,String checkCode) {
        try{
            receiveMailAccount=mail;
            //1.创建参数配置, 用于连接邮件服务器的参数配置
            Properties props = new Properties();                    //参数配置
            props.setProperty("mail.transport.protocol", "smtp");   //使用的协议（JavaMail规范要求）
            props.setProperty("mail.smtp.host", myEmailSMTPHost);   //发件人的邮箱的 SMTP 服务器地址
            props.setProperty("mail.smtp.auth", "true");            //需要请求认证

            props.put("mail.smtp.ssl.enable", true);
            props.setProperty("mail.smtp.port", "465");//设置端口
            props.setProperty("mail.smtp.socketFactory.port", "465");//设置ssl端口
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            //2.根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getInstance(props);

            //3.创建一封邮件
            MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,username,checkCode);

            //4.根据 Session获取邮件传输对象
            Transport transport = session.getTransport();

            // 5.使用邮箱账号和密码连接邮件服务器, 这里认证的邮箱必须与 message中的发件人邮箱一致,否则报错
            transport.connect(myEmailAccount, myEmailPassword);
            //6.发送邮件,发到所有的收件地址,message.getAllRecipients()获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("邮件发送成功 to "+mail);
            // 7. 关闭连接
            transport.close();
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String username,String checkCode) throws Exception {
        // 1.创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2.From:发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "Hms", "UTF-8"));
        // 3.To:收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, username, "UTF-8"));
        // 4.Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject("验证码", "UTF-8");
        // 5.Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(username+"您好，您正在进行账号注册，验证码为"+checkCode+",切勿将验证码泄露于他人。", "text/html;charset=UTF-8");
        // 6.设置发件时间
        message.setSentDate(new Date());
        // 7.保存设置
        message.saveChanges();
        return message;
    }
}

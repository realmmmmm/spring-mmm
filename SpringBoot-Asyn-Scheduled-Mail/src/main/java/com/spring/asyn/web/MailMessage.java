package com.spring.asyn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class MailMessage {

    @Autowired
    JavaMailSenderImpl javaMailSender;


    /**
     * 发送普通邮件
     * @param title  标题
     * @param info   内容
     * @param recipients  收件人
     * @param addresser   寄件人
     * @return
     */
    public void sendGeneralMail(String title,String info,String recipients,String addresser)  throws MessagingException , UnsupportedEncodingException {

        //封装简单的邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        //标题
        message.setSubject(title);
        message.setText(info);
        //发件人
        message.setFrom(addresser);
        //收件人
        message.setTo(recipients);
        javaMailSender.send(message);
    }

    /**
     * 发送高级邮件
     * @param title  标题
     * @param info   内容
     * @param recipients  收件人
     * @param addresser   寄件人
     * @return
     */
    public void sendAdvancedMail(String title,String info,String recipients,String addresser) throws MessagingException , UnsupportedEncodingException {

        System.out.println(title);
        System.out.println(info);
        System.out.println(recipients);
        System.out.println(addresser);

        //封装简单的邮件内容
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //通过消息帮助对象来设置发送的内容 ,第二个参数为true表示可以发送附件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true,"UTF-8");

        //标题
        messageHelper.setSubject(title);
        //第2个参数为true,才可以发送html代码
        messageHelper.setText(info, true);
        //发送附件
        messageHelper.addAttachment("1.jpg", new File("D:\\down\\1.jpg"));
        //发件人
        messageHelper.setFrom(addresser);
        //收件人
        messageHelper.setTo(recipients);
        javaMailSender.send(mimeMessage);

    }


}

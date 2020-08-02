package com.spring.asyn;

import com.spring.asyn.web.MailMessage;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;


@SpringBootTest
class AsynApplicationTests {

    //@Autowired
   JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads3() throws MessagingException {
        String title = "标题";
        String info = "<h2>放假了</h2>";
        String recipients = "821521880@qq.com";
        String addresser = "2392786006@qq.com";
        try {
            new MailMessage().sendAdvancedMail(title,info,recipients,addresser);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Test
    void contextLoads2() throws MessagingException {

    }

}

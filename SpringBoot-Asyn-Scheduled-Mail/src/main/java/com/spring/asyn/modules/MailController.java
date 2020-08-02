package com.spring.asyn.modules;

import com.spring.asyn.web.MailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
/**
 * 邮件发送
 */
@RestController
public class MailController {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    //获取寄件人 （有肯能寄件人和注册账号不一样）
    @Value("${spring.mail.username}")
    private String addresser;

    /**
     * 发送邮件
     * @param recipients  发送人
     * @return
     */
    @GetMapping("/mail/{recipients}")
    public String doFindUserProfile(@PathVariable("recipients") String recipients){

        String title = "标题";
        String info = "<h2>放假了</h2>";

        try {
            sendAdvancedMail(title,info,recipients,addresser);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return  "ok" + recipients;
    }

    //发送邮件
    private  void sendAdvancedMail(String title,String info,String recipients,String addresser) throws MessagingException {

        System.out.println(title);
        System.out.println(info);
        System.out.println(recipients);
        System.out.println(addresser);

        //封装简单的邮件内容
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //通过消息帮助对象来设置发送的内容 ,第二个参数为true表示可以发送附件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        //标题
        messageHelper.setSubject(title);
        //第2个参数为true,才可以发送html代码
        messageHelper.setText(info, true);

        //发送附件
        messageHelper.addAttachment("1.jpg", new File("D:\\down\\1.jpg"));
        messageHelper.addAttachment("2.jpg", new File("D:\\down\\2.jpg"));
        messageHelper.addAttachment("c.jpg", new File("D:\\down\\3.jpg"));
        //发件人
        messageHelper.setFrom(addresser);
        //收件人
        messageHelper.setTo(recipients);
        javaMailSender.send(mimeMessage);

    }

}

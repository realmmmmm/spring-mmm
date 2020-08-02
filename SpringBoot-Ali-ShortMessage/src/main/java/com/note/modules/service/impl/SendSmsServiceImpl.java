package com.note.modules.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.note.modules.service.SendSmsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


@Service
public class SendSmsServiceImpl implements SendSmsService {

    @Value("${web.ngari.accessKey.id}")
    private String userKey;

    @Value("${web.ngari.accessKey.secret}")
    private String userVal;

    //短信签名
    @Value("${web.ngari.signature}")
    private String signature;

    //日志记录器
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 阿里云发送短信
     * @param phone    手机号
     * @param template 模板名
     * @param code     验证码
     * @return
     */
    @Override
    public boolean send(String phone, String template, Map<String, Object> code) {
        //连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", userKey, userVal);
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
<<<<<<< HEAD
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
=======
        request.setSysDomain("xxxxxxxxx");
        request.setSysVersion("xxxxxxxx");
        request.setSysAction("xxxxxx");
>>>>>>> 68da45e499ad47fa891683b097ce1f7a8703dcdf
        //自定义参数   手机号 - 短信签名 - 模板样式
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", signature);
        request.putQueryParameter("TemplateCode", template);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            //将返回值转成JSON对象
            JSONObject jsonObject = JSONObject.parseObject(response.getData());
            String message = jsonObject.get("Message").toString();
            if("OK".equals(message)){
                return response.getHttpResponse().isSuccess();
            }else {
                logger.error("发送短信失败，原因：" + message + "。详细信息 ：" + response.getData()) ;
                return false;
            }

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}


package com.note.modules.controller;

import com.note.common.web.JsonResult;
import com.note.modules.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin  //跨越支持
public class VerificationCodeController {

	@Autowired
	private SendSmsService sendSmsService;

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	//短信模板名
	@Value("${web.ngari.template}")
	private String template;

	//发送验证码请求
	@PostMapping("/send/{phone}")
	public JsonResult doSendPhone(@PathVariable("phone") String phone){


		Map<String,String>  map = new HashMap<>();
		//对缓存里数据进行查询
		String code = redisTemplate.opsForValue().get(phone);

		System.out.println(code);
		if(!StringUtils.isEmpty(code)){

			System.out.println("已存在手机号");
			map.put("code",code);
			map.put("state","1");
			map.put("message","已存在，还没有过期");
			return new JsonResult(map);
		}

		//生成验证码到redis中
		code = UUID.randomUUID().toString().substring(0,4);
		HashMap<String,Object> param = new HashMap<>();
		param.put("code",code);

		System.out.println("验证码" + param);

		boolean isSend = sendSmsService.send(phone, template, param);
		if(isSend){
			System.out.println(code);
			redisTemplate.opsForValue().set(phone,code,1,TimeUnit.MINUTES);
			map.put("code",code);
			map.put("state","1");
			map.put("message","发送成功");

			System.out.println("写入数据库中");

			return new JsonResult(map);
		}else{
			map.put("code",null);
			map.put("state","0");
			map.put("message","发送失败");
			return new JsonResult(map);
		}

	}



}

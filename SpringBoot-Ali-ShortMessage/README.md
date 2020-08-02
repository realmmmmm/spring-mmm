# SpringBoot--阿里云
阿里云短信业务实战
=======
# SpringBoot--阿里云短信业务
阿里云短信业务实战 <br>
首先，我们注册阿里云账号，开启短信业务，充值1元即可。使用SpringBoot完成接口请求向手机发送验证码，把验证码保存到Redis中。

## 需要用到的技术

  1. 阿里云账号，开启短信业务服务 <br>
  2. SpringBoot基础 <br>
  3. 集成Redis，Redis基础 <br>

## 阿里云账号权限开通
``` bash
1 登录阿里云 ，有支付宝账号就能登录
2 点击控制台，点击头像，找到AccessKey管理
3 分部创建用户、用户组，授权后，得到账号和密钥
4 记住你的账号和密码，很重要，只有这个账号才能有权限操作阿里云里的业务功能
4 搜索框搜索短信服务，进行添加签名 和 模板管理
5 签名：就是短信发送的公司名或者业务 模板管理：短信内容，模板样式
```

## 需要引入的包
``` bash
  <!-- 阿里云短信验证码 -->
  <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-core</artifactId>
      <version>4.5.0</version>
  </dependency>
  <!-- 阿里巴巴的json处理 -->
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.62</version>
  </dependency>
  <!-- redis -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-redis</artifactId>
  </dependency>
```

## 如何使用
1. 导入对应的包   <br>
2. 修改配置文件，在rescources目录下 <br>
3. 浏览器输入，/home 路径后  <br>
4. 输入手机号，确定后向手机发送验证码。


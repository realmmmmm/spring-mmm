package com.note.modules.model;


import java.io.Serializable;

//短信验证码
public class VerificationCode implements Serializable {

    //主键
    private String id;
    //名字
    private String name;
    //验证码
    private String code;
    //创建时间
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VerificationCode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

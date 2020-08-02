package com.mybatis.io.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable{

    private int id;
    private String name;

    //一个老师对多个学生
    private List<Student> students;



}

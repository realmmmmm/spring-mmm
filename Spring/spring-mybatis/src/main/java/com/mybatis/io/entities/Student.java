package com.mybatis.io.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{

    private int id;
    private String name;

    //许多学生对一个老师
    //private Teacher teacher;

    //一对多
    private int tid;

}

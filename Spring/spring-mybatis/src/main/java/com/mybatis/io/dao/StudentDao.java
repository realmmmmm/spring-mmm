package com.mybatis.io.dao;


import com.mybatis.io.entities.Student;
import com.mybatis.io.entities.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    // 多对一   查询全部学生  有个字段是实体类
    List<Student> getStudentList();

    // 一对 多  查询某个老师下全部学生  有个字段是实体类
    Teacher getTeacherbyTid(@Param("tid") Integer tid);


}

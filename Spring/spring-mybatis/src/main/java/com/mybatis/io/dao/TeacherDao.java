package com.mybatis.io.dao;


import com.mybatis.io.entities.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

        // 二级缓存
        List<Teacher> getTeacher();

        // ehcache
}

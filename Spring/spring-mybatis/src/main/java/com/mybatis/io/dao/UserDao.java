package com.mybatis.io.dao;


import com.mybatis.io.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    // 普通查询
    List<User> getUserList();

    // 模糊查询
    List<User> getUserLike(@Param("value") String value);

    // resultMap的映射使用
    List<User> getUserListMap();

    /*
       分页查询
       startIndex：起始位置
       startIndex=(currentPage-1)*pageSize
       pageSize：页面大小
       currentPage：当前页
     */
    List<User> getUserPaging(Map<String,Integer> map);

    //分页插件  (未写)

    // 动态查询  if
    List<User> getUserIf(@Param("gender") Integer gender,@Param("userType") Integer userType);

    // choose  像 java 里的 if else
    List<User> getUserChoose(User user);

    // set  更新数据
    int setUser(User user);


    // foreach  对集合进行遍历，通常处理 in 条件语句
    List<User> getUserByIdList(Map<String, List<Integer>> map);

}

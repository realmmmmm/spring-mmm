package com.spring.io.dao;

import com.spring.io.entities.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUser();
    int addUser(User user);
    int delete(int id);

}

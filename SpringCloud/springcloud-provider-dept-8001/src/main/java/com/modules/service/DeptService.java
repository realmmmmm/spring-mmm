package com.modules.service;

import com.modules.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getAll();

    Dept getDept(Integer id);

    int addDept(Dept dept);
}

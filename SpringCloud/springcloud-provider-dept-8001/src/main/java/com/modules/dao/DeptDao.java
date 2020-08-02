package com.modules.dao;


import com.modules.pojo.Dept;

import java.util.List;

public interface DeptDao {

    List<Dept> getList();

    Dept getDept(Integer id);

    int addDept(Dept dept);

}

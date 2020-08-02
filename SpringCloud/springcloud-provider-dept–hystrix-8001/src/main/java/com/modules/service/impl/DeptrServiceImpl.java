package com.modules.service.impl;

import com.modules.dao.DeptDao;
import com.modules.pojo.Dept;
import com.modules.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptrServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> getAll() {
        return deptDao.getList();
    }

    @Override
    public Dept getDept(Integer id) {
        return deptDao.getDept(id);
    }

    @Override
    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }


}

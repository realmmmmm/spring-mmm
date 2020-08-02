package com.mybatis.io.dao;


import com.mybatis.io.entities.Bill;
import java.util.List;

public interface BilDao {

    // 普通查询  Lombok 插件
    List<Bill> getBillList();


}

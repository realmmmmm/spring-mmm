package com.spring.one.modules.dao;


import com.spring.one.modules.entities.Bill;
import com.spring.one.modules.entities.BillVo;
import com.spring.one.modules.entities.Provider;

import java.util.List;
import java.util.Map;

public interface BillDao {

    List<BillVo> getBill(BillVo billVo);

    BillVo getBillByBid(Integer bid);

    int updateBillVo(BillVo billVo);

    int addBillVo(BillVo billVo);

    int deleteBillVoByPid(Integer pid);

}

package com.spring.one;

import com.spring.one.modules.dao.ProviderDao;
import com.spring.one.modules.entities.Provider;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringoneApplicationTests {

//    @Autowired
//    BillDao billDao;

    //默认的日志
    Logger LOG = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {

        LOG.trace("trace11111");
        LOG.debug("debug11111");
        LOG.info("info11111");
        LOG.warn("warn11111");
    }

    @Autowired
    ProviderDao providerDao;

    @Test
    void doMybatis() {
//        Map<String,String> map = billDao.getBillByBid(1);
//        System.out.println(map);
    }

    @Test
    void doGetAllProvider() {

        List<Provider> list =providerDao.getProviders(null);
        System.out.println(55555);
        System.out.println(list);
        System.out.println(list);

    }



}

package com.spring.one.modules.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * 帐单实体类
 * @Version: 1.0
 */
public class BillVo extends Bill{

    private String providerName;

    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

}

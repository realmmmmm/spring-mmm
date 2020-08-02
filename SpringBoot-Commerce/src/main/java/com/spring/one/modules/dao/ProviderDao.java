package com.spring.one.modules.dao;

import com.spring.one.modules.entities.Provider;

import java.util.List;

public interface ProviderDao {

    List<Provider> getProviders(String providerName);

    Provider getProviderByPid(Integer pid);

    int updateProvider(Provider provider);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);



}

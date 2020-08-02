package com.spring.one.modules.service;

import com.spring.one.modules.entities.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAll(String providerName);

    Provider provider(Integer pid);

    void save(Provider provider);

    void add(Provider provider);

    void delete(Integer pid);

}

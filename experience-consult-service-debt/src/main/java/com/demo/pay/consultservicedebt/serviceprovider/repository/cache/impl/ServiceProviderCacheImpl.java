package com.demo.pay.consultservicedebt.serviceprovider.repository.cache.impl;

import com.demo.pay.consultservicedebt.serviceprovider.repository.cache.ServiceProviderCache;
import com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import com.demo.pay.consultservicedebt.util.generic.GenericCache;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ServiceProviderCacheImpl implements ServiceProviderCache {

  private final GenericCache<ServiceProviderResponse> genericCache;

  @Override
  public Completable save(ServiceProviderResponse serviceProvider) {
    return genericCache.save("SERVICE-PROVIDERS", String.valueOf(serviceProvider.getId()), serviceProvider);
  }

  @Override
  public Observable<ServiceProviderResponse> findAll() {
    return genericCache.findAllOfHash("SERVICE-PROVIDERS", ServiceProviderResponse.class);
  }

}

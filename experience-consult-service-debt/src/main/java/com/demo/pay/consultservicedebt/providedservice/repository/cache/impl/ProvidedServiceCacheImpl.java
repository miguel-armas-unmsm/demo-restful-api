package com.demo.pay.consultservicedebt.providedservice.repository.cache.impl;

import com.demo.pay.consultservicedebt.providedservice.util.model.dto.third.ProvidedServiceThird;
import com.demo.pay.consultservicedebt.providedservice.repository.cache.ProvidedServiceCache;
import com.demo.pay.consultservicedebt.util.generic.GenericCache;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProvidedServiceCacheImpl implements ProvidedServiceCache {

  private final GenericCache<ProvidedServiceThird> genericCache;

  @Override
  public Completable save(ProvidedServiceThird providedService) {
    return genericCache.save("PROVIDED-SERVICES", String.valueOf(providedService.getId()), providedService);
  }

  @Override
  public Observable<ProvidedServiceThird> findByServiceProviderId(Long serviceProviderId) {
    return genericCache.findAllOfHash("PROVIDED-SERVICES", ProvidedServiceThird.class)
        .filter(providedService -> providedService.getServiceProviderId().equals(serviceProviderId));
  }

}

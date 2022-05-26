package com.demo.pay.consultservicedebt.providedservice.repository.cache;

import com.demo.pay.consultservicedebt.providedservice.util.model.dto.third.ProvidedServiceThird;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface ProvidedServiceCache {

  Observable<ProvidedServiceThird> findByServiceProviderId(Long serviceProviderId);

  Completable save(ProvidedServiceThird serviceProvider);

}

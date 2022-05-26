package com.demo.pay.consultservicedebt.serviceprovider.repository.cache;

import com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface ServiceProviderCache {

  Observable<ServiceProviderResponse> findAll();

  Completable save(ServiceProviderResponse serviceProvider);

}

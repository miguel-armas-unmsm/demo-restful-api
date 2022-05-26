package com.demo.pay.consultservicedebt.serviceprovider.business.impl;

import static com.fisi.unmsm.support.logstash.Markers.SENSITIVE_TEXT;

import com.demo.pay.consultservicedebt.serviceprovider.business.ServiceProviderService;
import com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.third.ServiceProviderThird;
import com.demo.pay.consultservicedebt.util.constant.ErrorMessages;
import com.fisi.unmsm.support.exception.model.ApiException;
import com.demo.pay.consultservicedebt.serviceprovider.repository.cache.ServiceProviderCache;
import com.demo.pay.consultservicedebt.serviceprovider.repository.proxy.ServiceProviderProxy;
import com.demo.pay.consultservicedebt.serviceprovider.util.mapper.ServiceProviderMapper;
import com.fisi.unmsm.support.retrofit.HttpStreamingTransformer;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del
 * contexto Service Provider.<br/>
 *
 * <b>Class</b>: ServiceProviderServiceImpl<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ServiceProviderServiceImpl implements ServiceProviderService {

  private final ServiceProviderProxy serviceProviderProxy;
  private final ServiceProviderMapper serviceProviderMapper;
  private final ServiceProviderCache serviceProviderCache;

  @Override
  public Observable<ServiceProviderResponse> findAll() {
    return serviceProviderCache.findAll()
        .onErrorResumeNext(error -> ((ApiException) error).getHttpStatus().value() == 404
            ? this.updateAndFindServiceProviders()
            : Observable.error(error));
  }

  private Observable<ServiceProviderResponse> updateAndFindServiceProviders() {
    return serviceProviderProxy.findAll()
        .doOnError(error -> log.error(SENSITIVE_TEXT, ErrorMessages.ERROR_TO_CALL_SERVICE_PROVIDER_PROXY, error))
        .compose(HttpStreamingTransformer.of(ServiceProviderThird.class))
        .map(serviceProviderMapper::fromThirdToResponse)
        .flatMapCompletable(serviceProviderCache::save)
        .andThen(Observable.defer(serviceProviderCache::findAll));
  }

}

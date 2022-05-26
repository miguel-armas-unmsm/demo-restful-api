package com.demo.pay.consultservicedebt.providedservice.business.impl;

import static com.fisi.unmsm.support.logstash.Markers.SENSITIVE_TEXT;

import com.demo.pay.consultservicedebt.providedservice.business.ProvidedServiceService;
import com.demo.pay.consultservicedebt.providedservice.util.model.dto.response.ProvidedServiceResponse;
import com.demo.pay.consultservicedebt.providedservice.util.model.dto.third.ProvidedServiceThird;
import com.demo.pay.consultservicedebt.util.constant.ErrorMessages;
import com.fisi.unmsm.support.exception.model.ApiException;
import com.fisi.unmsm.support.retrofit.HttpStreamingTransformer;
import com.demo.pay.consultservicedebt.providedservice.repository.cache.ProvidedServiceCache;
import com.demo.pay.consultservicedebt.providedservice.repository.proxy.ProvidedServiceProxy;
import com.demo.pay.consultservicedebt.providedservice.util.mapper.ProvidedServiceMapper;
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
public class ProvidedServiceServiceImpl implements ProvidedServiceService {

  private final ProvidedServiceProxy providedServiceProxy;
  private final ProvidedServiceMapper providedServiceMapper;
  private final ProvidedServiceCache providedServiceCache;

  @Override
  public Observable<ProvidedServiceResponse> findByServiceProviderId(Long serviceProviderId) {
    return providedServiceCache.findByServiceProviderId(serviceProviderId)
        .onErrorResumeNext(error -> ((ApiException) error).getHttpStatus().value() == 404
            ? this.updateAndFindProvidedServices(serviceProviderId)
            : Observable.error(error))
        .map(providedServiceMapper::fromThirdToResponse);
  }

  private Observable<ProvidedServiceThird> updateAndFindProvidedServices(Long serviceProviderId) {
    return providedServiceProxy.findByServiceProviderId(serviceProviderId)
        .doOnError(error -> log.error(SENSITIVE_TEXT, ErrorMessages.ERROR_TO_CALL_PROVIDED_SERVICE_PROXY, error))
        .compose(HttpStreamingTransformer.of(ProvidedServiceThird.class))
        .flatMapCompletable(providedServiceCache::save)
        .andThen(Observable.defer(() -> providedServiceCache.findByServiceProviderId(serviceProviderId)));
  }

}

package com.demo.pay.consultservicedebt.servicebill.business.impl;

import static com.fisi.unmsm.support.logstash.Markers.SENSITIVE_TEXT;

import com.fisi.unmsm.support.retrofit.HttpStreamingTransformer;
import com.demo.pay.consultservicedebt.servicebill.business.ServiceBillService;
import com.demo.pay.consultservicedebt.servicebill.repository.proxy.ServiceBillProxy;
import com.demo.pay.consultservicedebt.servicebill.util.mapper.ServiceBillMapper;
import com.demo.pay.consultservicedebt.servicebill.util.model.dto.response.ServiceBillResponse;
import com.demo.pay.consultservicedebt.servicebill.util.model.dto.third.ServiceBillThird;
import com.demo.pay.consultservicedebt.util.constant.ErrorMessages;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del
 * contexto Service Bill.<br/>
 *
 * <b>Class</b>: ServiceBillServiceImpl<br/>
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
public class ServiceBillServiceImpl implements ServiceBillService {

  private final ServiceBillProxy serviceBillProxy;
  private final ServiceBillMapper serviceBillMapper;

  @Override
  public Observable<ServiceBillResponse> findByProvidedServiceId(Long providedServiceId) {
    return serviceBillProxy.findByProvidedServiceId(providedServiceId)
        .doOnError(error -> log.error(SENSITIVE_TEXT, ErrorMessages.ERROR_TO_CALL_SERVICE_BILL_PROXY, error))
        .compose(HttpStreamingTransformer.of(ServiceBillThird.class))
        .map(serviceBillMapper::fromThirdToResponse);
  }
}

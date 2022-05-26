package com.demo.pay.servicebill.service.impl;

import com.demo.pay.servicebill.util.exception.ExceptionCatalog;
import com.demo.pay.servicebill.util.mapper.ServiceBillMapper;
import com.demo.pay.servicebill.util.model.dto.response.ServiceBillResponse;
import com.demo.pay.servicebill.service.ServiceBillService;
import com.demo.pay.servicebill.repository.ServiceBillRepository;
import io.reactivex.Observable;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Component
public class ServiceBillServiceImpl implements ServiceBillService {

  private final ServiceBillRepository serviceBillRepository;
  private final ServiceBillMapper serviceBillMapper;

  @Override
  public Observable<ServiceBillResponse> findByProvidedServiceId(Long providedServiceId) {
    return (Optional.ofNullable(providedServiceId).isEmpty()
        ? Observable.fromIterable(serviceBillRepository.findAll())
        : Observable.fromIterable((serviceBillRepository.findByProvidedServiceId(providedServiceId))))
        .map(serviceBillMapper::fromEntityToResponse)
        .switchIfEmpty(Observable.error(ExceptionCatalog.ERROR0001.buildException()));
  }
}

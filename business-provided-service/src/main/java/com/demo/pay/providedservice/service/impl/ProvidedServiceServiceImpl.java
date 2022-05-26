package com.demo.pay.providedservice.service.impl;

import com.demo.pay.providedservice.repository.ProvidedServiceRepository;
import com.demo.pay.providedservice.service.ProvidedServiceService;
import com.demo.pay.providedservice.util.mapper.ProvidedServiceMapper;
import com.demo.pay.providedservice.util.exception.ExceptionCatalog;
import com.demo.pay.providedservice.util.model.dto.response.ProvidedServiceResponse;
import io.reactivex.Observable;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del
 * contexto Provided Service.<br/>
 *
 * <b>Class</b>: ProvidedServiceServiceImpl<br/>
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
public class ProvidedServiceServiceImpl implements ProvidedServiceService {

  private final ProvidedServiceRepository providedServiceRepository;
  private final ProvidedServiceMapper providedServiceMapper;

  @Override
  public Observable<ProvidedServiceResponse> findByServiceProviderId(Long ServiceProviderId) {
    return (Optional.ofNullable(ServiceProviderId).isEmpty()
        ? Observable.fromIterable(providedServiceRepository.findAll())
        : Observable.fromIterable((providedServiceRepository.findByServiceProviderId(ServiceProviderId))))
        .map(providedServiceMapper::fromEntityToResponse)
        .switchIfEmpty(Observable.error(ExceptionCatalog.ERROR0001.buildException()));
  }
}

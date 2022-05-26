package com.demo.pay.serviceprovider.service.impl;

import com.demo.pay.serviceprovider.service.ServiceProviderService;
import com.demo.pay.serviceprovider.util.mapper.ServiceProviderMapper;
import com.demo.pay.serviceprovider.util.exception.ExceptionCatalog;
import com.demo.pay.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import com.demo.pay.serviceprovider.repository.ServiceProviderRepository;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Component
public class ServiceProviderServiceImpl implements ServiceProviderService {

  private final ServiceProviderRepository serviceProviderRepository;
  private final ServiceProviderMapper serviceProviderMapper;

  @Override
  public Observable<ServiceProviderResponse> findAll() {
    return Observable.fromIterable(serviceProviderRepository.findAll())
        .map(serviceProviderMapper::fromEntityToResponse)
        .switchIfEmpty(Observable.error(ExceptionCatalog.ERROR0001.buildException()));
  }
}

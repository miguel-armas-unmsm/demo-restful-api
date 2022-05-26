package com.demo.pay.serviceprovider.service;

import com.demo.pay.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import io.reactivex.Observable;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del
 * contexto Service Provider.<br/>
 *
 * <b>Interface</b>: ServiceProviderService<br/>
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
public interface ServiceProviderService {

  Observable<ServiceProviderResponse> findAll();
}

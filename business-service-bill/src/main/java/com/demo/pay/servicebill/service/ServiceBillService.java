package com.demo.pay.servicebill.service;

import com.demo.pay.servicebill.util.model.dto.response.ServiceBillResponse;
import io.reactivex.Observable;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del
 * contexto Service Bill.<br/>
 *
 * <b>Interface</b>: ServiceBillService<br/>
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
public interface ServiceBillService {

  Observable<ServiceBillResponse> findByProvidedServiceId(Long providedServiceId);
}

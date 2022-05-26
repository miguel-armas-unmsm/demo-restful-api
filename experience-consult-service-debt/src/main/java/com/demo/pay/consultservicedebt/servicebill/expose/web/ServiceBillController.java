package com.demo.pay.consultservicedebt.servicebill.expose.web;

import com.demo.pay.consultservicedebt.servicebill.business.ServiceBillService;
import com.demo.pay.consultservicedebt.servicebill.util.model.dto.response.ServiceBillResponse;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST
 * los servicios del contexto Service Bill.<br/>
 *
 * <b>Class</b>: ServiceBillController<br/>
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
@RestController
@RequestMapping("/demo/pay/experience/v1/consult-service-debt/service-bills")
public class ServiceBillController {

  private final ServiceBillService service;

  @GetMapping(produces = "application/stream+json")
  public ResponseEntity<Observable<ServiceBillResponse>> findByProvidedServiceId(
      @RequestParam(value = "providedServiceId") Long providedServiceId) {
    return ResponseEntity.ok(service.findByProvidedServiceId(providedServiceId));
  }

}

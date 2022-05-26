package com.demo.pay.servicebill.expose.web;

import com.demo.pay.servicebill.util.model.dto.response.ServiceBillResponse;
import com.demo.pay.servicebill.service.ServiceBillService;
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
 * <b>Class</b>: ProvidedServiceController<br/>
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
@RequestMapping("/demo/pay/business/v1/service-bills")
public class ServiceBillController {

  private final ServiceBillService service;

  @GetMapping(produces = "application/stream+json")
  public ResponseEntity<Observable<ServiceBillResponse>> findByProvidedServiceId(
      @RequestParam(value = "providedServiceId", required = false) Long providedServiceId) {
    return ResponseEntity.ok(service.findByProvidedServiceId(providedServiceId));
  }

}

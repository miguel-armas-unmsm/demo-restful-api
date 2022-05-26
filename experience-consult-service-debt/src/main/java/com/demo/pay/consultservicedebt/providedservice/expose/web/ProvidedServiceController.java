package com.demo.pay.consultservicedebt.providedservice.expose.web;

import com.demo.pay.consultservicedebt.providedservice.business.ProvidedServiceService;
import com.demo.pay.consultservicedebt.providedservice.util.model.dto.response.ProvidedServiceResponse;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST
 * los servicios del contexto Provided Service.<br/>
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
@RequestMapping("/demo/pay/experience/v1/consult-service-debt/provided-services")
public class ProvidedServiceController {

  private final ProvidedServiceService service;

  @GetMapping(produces = "application/stream+json")
  public ResponseEntity<Observable<ProvidedServiceResponse>> findByServiceProviderId(
      @RequestParam(value = "serviceProviderId", required = false) Long serviceProviderId) {
    return ResponseEntity.ok(service.findByServiceProviderId(serviceProviderId));
  }

}

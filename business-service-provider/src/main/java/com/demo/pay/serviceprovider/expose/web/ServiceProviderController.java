package com.demo.pay.serviceprovider.expose.web;

import com.demo.pay.serviceprovider.service.ServiceProviderService;
import com.demo.pay.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST
 * los servicios del contexto Service Provider.<br/>
 *
 * <b>Class</b>: ServiceProviderController<br/>
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
@RequestMapping("/demo/pay/business/v1/service-providers")
public class ServiceProviderController {

  private final ServiceProviderService service;

  @GetMapping(produces = "application/stream+json")
  public ResponseEntity<Observable<ServiceProviderResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

}

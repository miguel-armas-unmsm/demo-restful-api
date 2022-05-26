package com.demo.pay.consultservicedebt.accountholder.expose.web;

import com.demo.pay.consultservicedebt.accountholder.business.AccountHolderService;
import com.demo.pay.consultservicedebt.accountholder.util.model.dto.response.AccountHolderResponse;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST
 * los servicios del contexto Account Holder.<br/>
 *
 * <b>Class</b>: AccountHolderController<br/>
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
@RequestMapping("/demo/pay/experience/v1/consult-service-debt/account-holders")
public class AccountHolderController {

  private final AccountHolderService service;

  @GetMapping(produces = "application/stream+json", value = "/{id}")
  public ResponseEntity<Single<AccountHolderResponse>> findByServiceProviderId(
      @PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

}

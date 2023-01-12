package com.demo.bbq.business.diningroomorder.expose.web;

import java.net.URI;
import java.util.List;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.demo.bbq.business.diningroomorder.service.DiningRoomOrderService;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.DiningRoomOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST los servicios del contexto
 * Menu Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bbq/business/v1/dining-room-orders")
public class DiningRoomOrderController {

  private final DiningRoomOrderService service;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DiningRoomOrderResponse> findByTableNumber(
      @RequestParam(value = "tableNumber") Integer tableNumber) {
    DiningRoomOrderResponse diningRoomOrder = service.findByTableNumber(tableNumber);
    return (diningRoomOrder == null)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(diningRoomOrder);
  }

  @PatchMapping
  public ResponseEntity<Void> generateTableOrder(HttpServletRequest servletRequest,
                                             @Valid @RequestBody List<MenuOrderRequest> menuOrderRequestList,
                                             @RequestParam(value = "tableNumber") Integer tableNumber) {
    Long tableOrderId = service.generateTableOrder(menuOrderRequestList, tableNumber);
    return (tableOrderId == null)
        ? ResponseEntity.badRequest().build()
        : ResponseEntity.created(buildPutUriLocation.apply(servletRequest, tableOrderId.toString())).build();
  }

  private final static BiFunction<HttpServletRequest, String, URI> buildPutUriLocation = (servletRequest, id) ->
      ServletUriComponentsBuilder.fromRequestUri(servletRequest)
      .buildAndExpand()
      .toUri();
}

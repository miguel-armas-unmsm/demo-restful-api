package com.demo.bbq.business.diningroomorder.expose.web;

import java.net.URI;
import java.util.List;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.demo.bbq.business.diningroomorder.service.DiningRoomOrderService;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.DiningRoomOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.MenuOptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

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
public class MenuOptionController {

  private final DiningRoomOrderService service;

  @GetMapping(produces = "application/stream+json")
  public Mono<ResponseEntity<MenuOptionResponse>> findByTableNumber(
      @RequestParam(value = "tableNumber") Integer tableNumber) {
    return service.findByTableNumber(tableNumber)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.noContent().build());
  }

  @PostMapping
  public Mono<ResponseEntity<Void>> save(HttpServletRequest servletRequest,
                                         @Valid @RequestBody DiningRoomOrderRequest diningRoomOrder) {
    return service.save(diningRoomOrder)
        .map(diningRoomOrderId -> ResponseEntity
            .created(buildPostUriLocation.apply(servletRequest, diningRoomOrderId)).build());
  }

  @PatchMapping
  public Mono<ResponseEntity<Object>> update(HttpServletRequest servletRequest,
                                             @Valid @RequestBody List<MenuOptionRequest> menuOptionList,
                                             @RequestParam(value = "tableNumber") Integer tableNumber) {
    return service.addToOrder(menuOptionList, tableNumber)
        .map(diningRoomOrderId -> ResponseEntity
            .created(buildPutUriLocation.apply(servletRequest, diningRoomOrderId)).build())
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  private final static BiFunction<HttpServletRequest, String, URI> buildPostUriLocation = (servletRequest, id) ->
      ServletUriComponentsBuilder.fromRequestUri(servletRequest)
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();

  private final static BiFunction<HttpServletRequest, String, URI> buildPutUriLocation = (servletRequest, id) ->
      ServletUriComponentsBuilder.fromRequestUri(servletRequest)
      .buildAndExpand()
      .toUri();
}

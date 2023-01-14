package com.demo.bbq.business.diningroomorder.expose.web;

import java.util.List;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import com.demo.bbq.business.diningroomorder.service.DiningRoomOrderService;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.DiningRoomOrderResponse;
import com.demo.bbq.support.logstash.Markers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
public class DiningRoomOrderController {

  private final DiningRoomOrderService diningRoomOrderService;

  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Mono<DiningRoomOrderResponse> findByTableNumber(
      HttpServletRequest servletRequest, @RequestParam(value = "tableNumber") Integer tableNumber) {
    logRequest.accept(servletRequest);
    return diningRoomOrderService.findByTableNumber(tableNumber);
  }

  @PatchMapping
  public Mono<Void> generateTableOrder(HttpServletRequest servletRequest,
                                       HttpServletResponse servletResponse,
                                       @Valid @RequestBody List<MenuOrderRequest> menuOrderRequestList,
                                       @RequestParam(value = "tableNumber") Integer tableNumber) {
    logRequest.accept(servletRequest);
    return diningRoomOrderService.generateTableOrder(menuOrderRequestList, tableNumber)
        .doOnSuccess(tableOrderId -> servletResponse.setStatus(201))
        .then(Mono.empty());
  }

  private final static Consumer<HttpServletRequest> logRequest = servletRequest->
      log.info(Markers.SENSITIVE_JSON, "{}", servletRequest.getMethod() + ": " + servletRequest.getRequestURI());

}

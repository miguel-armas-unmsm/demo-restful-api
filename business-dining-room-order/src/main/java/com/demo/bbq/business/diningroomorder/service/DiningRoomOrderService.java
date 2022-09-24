package com.demo.bbq.business.diningroomorder.service;

import com.demo.bbq.business.diningroomorder.util.model.dto.request.DiningRoomOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.MenuOptionResponse;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del contexto Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
public interface DiningRoomOrderService {

  Mono<String> save(DiningRoomOrderRequest diningRoomOrder);

  Mono<String> addToOrder(List<MenuOptionRequest> menuOptionList, Integer tableNumber);

  Mono<MenuOptionResponse> findByTableNumber(Integer tableNumber);
}

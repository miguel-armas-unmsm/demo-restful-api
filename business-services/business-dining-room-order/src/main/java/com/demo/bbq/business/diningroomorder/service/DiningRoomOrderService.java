package com.demo.bbq.business.diningroomorder.service;

import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.DiningRoomOrderResponse;
import java.util.List;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del contexto Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
public interface DiningRoomOrderService {

  Long generateTableOrder(List<MenuOrderRequest> menuOrderRequestList, Integer tableNumber);

  DiningRoomOrderResponse findByTableNumber(Integer tableNumber);
}
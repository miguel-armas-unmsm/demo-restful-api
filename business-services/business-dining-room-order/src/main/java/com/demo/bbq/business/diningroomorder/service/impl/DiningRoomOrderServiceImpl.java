package com.demo.bbq.business.diningroomorder.service.impl;

import com.demo.bbq.business.diningroomorder.repository.database.MenuOrderRepository;
import com.demo.bbq.business.diningroomorder.repository.api.MenuOptionApi;
import com.demo.bbq.business.diningroomorder.service.DiningRoomOrderService;
import com.demo.bbq.business.diningroomorder.repository.database.TableRepository;
import com.demo.bbq.business.diningroomorder.util.exception.ExceptionCatalog;
import com.demo.bbq.business.diningroomorder.util.mapper.MenuOrderMapper;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.DiningRoomOrderResponse;
import com.demo.bbq.business.diningroomorder.util.model.entity.MenuOrder;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del contexto Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class DiningRoomOrderServiceImpl implements DiningRoomOrderService {

  private final TableRepository tableRepository;
  private final MenuOrderRepository menuOrderRepository;

  private final MenuOptionApi menuOptionApi;
  private final MenuOrderMapper menuOrderMapper;

  @Override
  public DiningRoomOrderResponse findByTableNumber(Integer tableNumber) {
    return tableRepository.findByTableNumber(tableNumber)
        .map(table -> DiningRoomOrderResponse.builder()
              .tableNumber(table.getTableNumber())
              .menuOrderList(menuOrderMapper.fromEntityListToRequestList(table.getMenuOrderList()))
              .build())
        .orElse(null);
  }

  @Override
  public Long generateTableOrder(List<MenuOrderRequest> menuOrderRequestList, Integer tableNumber) {
    return tableRepository.findByTableNumber(tableNumber)
        .map(table -> {

          menuOrderRequestList.forEach(menuOption -> {
            menuOptionApi.findById(menuOption.getMenuOptionId())
                .onErrorResumeNext(Observable.error(ExceptionCatalog.ERROR1001.buildException("id: " + menuOption.getMenuOptionId())))
                .blockingFirst();

                menuOrderRepository.save(MenuOrder.builder()
                    .tableId(table.getId())
                    .menuOptionId(menuOption.getMenuOptionId())
                    .quantity(menuOption.getQuantity())
                    .build());
          });

          table.setIsAvailable(Boolean.FALSE);
          tableRepository.save(table);
          return table.getId();
        })
        .orElse(null);
  }

}

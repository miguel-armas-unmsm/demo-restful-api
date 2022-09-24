package com.demo.bbq.business.diningroomorder.service.impl;

import com.demo.bbq.business.diningroomorder.repository.proxy.MenuOptionProxy;
import com.demo.bbq.business.diningroomorder.service.DiningRoomOrderService;
import com.demo.bbq.business.diningroomorder.repository.database.DiningRoomOrderRepository;
import com.demo.bbq.business.diningroomorder.util.exception.ExceptionCatalog;
import com.demo.bbq.business.diningroomorder.util.mapper.DiningRoomOrderMapper;
import com.demo.bbq.business.diningroomorder.util.mapper.MenuOptionMapper;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.DiningRoomOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.diningroomorder.util.model.entity.DiningRoomOrder;
import io.reactivex.BackpressureStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

  private final DiningRoomOrderRepository diningRoomOrderRepository;
  private final MenuOptionProxy menuOptionProxy;
  private final MenuOptionMapper menuOptionMapper;
  private final DiningRoomOrderMapper diningRoomOrderMapper;

  @Override
  public Mono<MenuOptionResponse> findByTableNumber(Integer tableNumber) {
    return diningRoomOrderRepository.findByTableNumber(tableNumber)
        .filter(DiningRoomOrder::getIsActive)
        .flatMap(diningRoomOrder -> Flux.fromIterable(diningRoomOrder.getMenuOptionList())
          .flatMap(menuOption -> RxJava2Adapter.observableToFlux(menuOptionProxy
              .findById(menuOption.getMenuOptionId()), BackpressureStrategy.BUFFER)
              .map(menuOptionThird -> menuOptionMapper.fromThirdToResponse(menuOptionThird, menuOption.getQuantity()))))
        .single();
  }

  @Override
  public Mono<String> save(DiningRoomOrderRequest diningRoomOrder) {
    return diningRoomOrderRepository.findByTableNumber(diningRoomOrder.getTableNumber())
        .filter(DiningRoomOrder::getIsActive)
        .count()
        .flatMap(ordersNumber -> {
          if (ordersNumber > 1) {
            throw ExceptionCatalog.ERROR1000.buildException();
          }
          if (ordersNumber == 1) {
            throw ExceptionCatalog.ERROR1001.buildException();
          }
          return diningRoomOrderRepository.save(diningRoomOrderMapper.fromRequestToEntity(diningRoomOrder, Boolean.TRUE));
        })
        .map(DiningRoomOrder::getId)
        .single();
  }

  @Override
  public Mono<String> addToOrder(List<MenuOptionRequest> menuOptionList, Integer tableNumber) {
    return diningRoomOrderRepository.findByTableNumber(tableNumber)
        .map(diningRoomOrder -> {
          Collection<MenuOptionRequest> menuOptionCollection = new ArrayList<>(menuOptionList);
          diningRoomOrder.getMenuOptionList().addAll(menuOptionMapper.fromEntityListToRequestList(menuOptionCollection));
          return diningRoomOrder;
        })
        .flatMap(diningRoomOrderRepository::save)
        .single()
        .map(DiningRoomOrder::getId);
  }

}

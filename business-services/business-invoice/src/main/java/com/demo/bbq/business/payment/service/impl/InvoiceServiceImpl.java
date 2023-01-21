package com.demo.bbq.business.payment.service.impl;

import com.demo.bbq.business.payment.broker.consumer.InvoiceProducer;
import com.demo.bbq.business.payment.repository.cache.DiningRoomOrderApi;
import com.demo.bbq.business.payment.repository.cache.MenuOptionApi;
import com.demo.bbq.business.payment.service.InvoiceService;
import com.demo.bbq.business.payment.util.model.dto.request.InvoiceRequest;
import com.demo.bbq.business.payment.util.model.dto.response.InvoiceResponse;
import com.demo.bbq.business.payment.util.model.dto.response.MenuOrderResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del contexto Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class InvoiceServiceImpl implements InvoiceService {

  private final DiningRoomOrderApi diningRoomOrderApi;
  private final MenuOptionApi menuOptionApi;
  private final InvoiceProducer invoiceProducer;

  @Override
  public Single<InvoiceResponse> generateInvoice(Integer tableNumber) {
    List<MenuOrderResponse> menuOrderResponseList = new ArrayList<>();
    AtomicReference<BigDecimal> subtotalInvoice = new AtomicReference<>(BigDecimal.ZERO);
    BigDecimal igv = new BigDecimal("0.01");
    return diningRoomOrderApi.findByTableNumber(tableNumber)
        .flatMapObservable(diningRoomOrder -> Observable.fromIterable(diningRoomOrder.getMenuOrderList()))
        .flatMapSingle(menuOrder -> menuOptionApi.findById(menuOrder.getMenuOptionId())
            .doOnSuccess(menuOptionFound -> {
              BigDecimal totalMenu = menuOptionFound.getPrice().multiply(new BigDecimal(menuOrder.getQuantity().toString()));
              BigDecimal actualAmount = subtotalInvoice.get();
              subtotalInvoice.set(actualAmount.add(totalMenu));
              MenuOrderResponse menuOrderResponse = MenuOrderResponse.builder()
                  .price(menuOptionFound.getPrice())
                  .quantity(menuOrder.getQuantity())
                  .description(menuOptionFound.getDescription())
                  .total(totalMenu)
                  .build();
              menuOrderResponseList.add(menuOrderResponse);
            })
        )
        .ignoreElements()
        .andThen(Single.defer(() -> Single.just(InvoiceResponse.builder() // defer will makes sure each subscriber can get its own source sequence, independent of the other subscribers
            .menuOrderList(menuOrderResponseList)
            .subtotal(subtotalInvoice.get())
            .igv(igv)
            .total(subtotalInvoice.get().add(subtotalInvoice.get().multiply(igv)))
            .build())));
  }

  @Override
  public Completable sendToPay(InvoiceRequest invoiceRequest) {
    return this.generateInvoice(invoiceRequest.getTableNumber())
        .map(invoice -> new com.google.gson.Gson().toJson(invoice))
        .doOnSuccess(invoiceProducer::sendMessage)
        .ignoreElement();
  }

}

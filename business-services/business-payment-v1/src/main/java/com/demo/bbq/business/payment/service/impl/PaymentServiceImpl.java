package com.demo.bbq.business.payment.service.impl;

import com.demo.bbq.business.payment.service.PaymentService;
import com.demo.bbq.business.payment.util.model.dto.response.PaymentResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
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
public class PaymentServiceImpl implements PaymentService {

  @Override
  public Single<Long> save() {
    return null;
  }

  @Override
  public Observable<PaymentResponse> findAll() {
    return null;
  }
}

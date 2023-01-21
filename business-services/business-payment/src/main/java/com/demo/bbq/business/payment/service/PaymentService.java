package com.demo.bbq.business.payment.service;

import com.demo.bbq.business.payment.util.model.dto.response.PaymentResponse;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del contexto Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
public interface PaymentService {

  Single<Long> save();

  Observable<PaymentResponse> findAll();
}

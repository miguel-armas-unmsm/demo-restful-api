package com.demo.bbq.business.payment.service;

import com.demo.bbq.business.payment.util.model.dto.request.InvoiceRequest;
import com.demo.bbq.business.payment.util.model.dto.response.InvoiceResponse;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del contexto Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
public interface InvoiceService {

  Single<InvoiceResponse> generateInvoice(Integer tableNumber);

  Completable sendToPay(InvoiceRequest invoiceRequest);

}

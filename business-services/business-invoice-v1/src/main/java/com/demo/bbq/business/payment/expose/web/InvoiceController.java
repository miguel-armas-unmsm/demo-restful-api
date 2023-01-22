package com.demo.bbq.business.payment.expose.web;

import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import com.demo.bbq.business.payment.service.InvoiceService;
import com.demo.bbq.business.payment.util.model.dto.request.InvoiceRequest;
import com.demo.bbq.business.payment.util.model.dto.response.InvoiceResponse;
import com.demo.bbq.support.logstash.Markers;
import io.reactivex.Completable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST los servicios del contexto
 * Menu Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bbq/business/v1/invoices")
public class InvoiceController {

  private final InvoiceService invoiceService;

  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Single<InvoiceResponse> generateInvoice(
      HttpServletRequest servletRequest, @RequestParam(value = "tableNumber") Integer tableNumber) {
    logRequest.accept(servletRequest);
    return invoiceService.generateInvoice(tableNumber);
  }

  @PostMapping("/send-to-pay")
  public Completable sendToPay(HttpServletRequest servletRequest,
                                        HttpServletResponse servletResponse,
                                        @Valid @RequestBody InvoiceRequest invoiceRequest) {
    logRequest.accept(servletRequest);
    return invoiceService.sendToPay(invoiceRequest)
        .doOnComplete(() -> servletResponse.setStatus(201));
  }

  private final static Consumer<HttpServletRequest> logRequest = servletRequest->
      log.info(Markers.SENSITIVE_JSON, "{}", servletRequest.getMethod() + ": " + servletRequest.getRequestURI());

}

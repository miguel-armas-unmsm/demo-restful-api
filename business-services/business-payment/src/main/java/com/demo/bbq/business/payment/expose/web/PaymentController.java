package com.demo.bbq.business.payment.expose.web;

import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import com.demo.bbq.business.payment.service.PaymentService;
import com.demo.bbq.business.payment.util.model.dto.response.PaymentResponse;
import com.demo.bbq.support.logstash.Markers;
import io.reactivex.Observable;
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
public class PaymentController {

  private final PaymentService paymentService;

  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Observable<PaymentResponse> findAll(HttpServletRequest servletRequest) {
    logRequest.accept(servletRequest);
    return paymentService.findAll();
  }

  private final static Consumer<HttpServletRequest> logRequest = servletRequest->
      log.info(Markers.SENSITIVE_JSON, "{}", servletRequest.getMethod() + ": " + servletRequest.getRequestURI());

}

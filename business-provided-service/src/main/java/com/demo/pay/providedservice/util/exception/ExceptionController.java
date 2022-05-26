package com.demo.pay.providedservice.util.exception;

import com.fisi.unmsm.support.exception.model.ApiException;
import com.fisi.unmsm.support.exception.model.ApiExceptionDto;
import com.fisi.unmsm.support.exception.util.mapper.ApiExceptionMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ApiException.class)
  public final ResponseEntity<ApiExceptionDto> sendException(ApiException exception, WebRequest request) {
    return new ResponseEntity<>(ApiExceptionMapper.buildApiExceptionResponse.apply(exception), exception.getHttpStatus());
  }
}
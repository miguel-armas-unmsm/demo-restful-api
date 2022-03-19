package com.demo.bbq.menuoption.util.exception.impl.expose.web;

import com.demo.bbq.menuoption.util.exception.impl.model.ApiException;
import com.demo.bbq.menuoption.util.exception.impl.util.mapper.ApiExceptionMapper;
import com.demo.bbq.menuoption.util.exception.impl.model.ApiExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ApiException.class)
  public final ResponseEntity<ApiExceptionDto> sendException(ApiException exception, WebRequest request) {
    return new ResponseEntity<>(ApiExceptionMapper.buildApiExceptionResponse.apply(exception), exception.getHttpStatus());
  }
}

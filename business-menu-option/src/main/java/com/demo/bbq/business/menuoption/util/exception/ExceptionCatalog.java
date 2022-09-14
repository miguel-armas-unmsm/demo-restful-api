package com.demo.bbq.business.menuoption.util.exception;

import com.demo.bbq.support.exception.basic.model.ApiException;
import com.demo.bbq.support.logstash.Markers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@AllArgsConstructor
@Getter
public enum ExceptionCatalog {

  ERROR0001("No se encontró la opción de menú solicitada.", HttpStatus.NOT_FOUND, " [MenuOptionServiceImpl - findById]");

  private final String description;
  private final HttpStatus httpStatus;
  private final String stackTrace;

  public ApiException buildException(Throwable cause) {
    return (cause instanceof ApiException)
        ? (ApiException) cause
        : new ApiException(this.name(), this.getDescription(), this.getHttpStatus(), cause);
  }

  public ApiException buildException() {
    ApiException apiException = new ApiException(this.name(), this.getDescription(), this.getHttpStatus(), new Throwable());
    log.error(Markers.SENSITIVE_TEXT, this.name().concat(this.stackTrace), apiException);
    return apiException;
  }

}

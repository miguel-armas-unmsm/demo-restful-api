package com.demo.bbq.menuoption.util.exception;

import com.demo.bbq.global.exception.model.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.demo.bbq.global.logstash.Markers.SENSITIVE_TEXT;

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
    log.error(SENSITIVE_TEXT, this.name().concat(this.stackTrace), apiException);
    return apiException;
  }

}

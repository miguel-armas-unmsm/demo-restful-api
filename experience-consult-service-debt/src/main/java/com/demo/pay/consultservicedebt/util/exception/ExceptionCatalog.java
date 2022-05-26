package com.demo.pay.consultservicedebt.util.exception;

import com.fisi.unmsm.support.exception.model.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionCatalog {

  ERROR0001("No se encontraron registros en caché.", HttpStatus.NOT_FOUND);

  private final String description;
  private final HttpStatus httpStatus;

  public ApiException buildException(Throwable cause) {
    return (cause instanceof ApiException)
        ? (ApiException) cause
        : ApiException.builder(this.name(), this.getDescription(), this.getHttpStatus())
        .cause(cause)
        .build();
  }

  public ApiException buildException() {
    return ApiException.builder(this.name(), this.getDescription(), this.getHttpStatus())
        .build();
  }

}

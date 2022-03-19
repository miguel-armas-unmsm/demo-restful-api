package com.demo.bbq.menuoption.util.exception;

import com.demo.bbq.menuoption.util.exception.impl.model.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionCatalog {

  ERROR0001("No se encontró la opción de menú solicitada.", HttpStatus.NOT_FOUND);

  private final String description;
  private final HttpStatus httpStatus;

  public ApiException buildException(Throwable cause) {
    return (cause instanceof ApiException)
        ? (ApiException) cause
        : new ApiException(this.name(), this.getDescription(), this.getHttpStatus(), cause);
  }

  public ApiException buildException() {
    return new ApiException(this.name(), this.getDescription(), this.getHttpStatus(), new Throwable());
  }

}

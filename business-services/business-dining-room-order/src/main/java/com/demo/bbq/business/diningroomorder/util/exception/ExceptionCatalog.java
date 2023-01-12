package com.demo.bbq.business.diningroomorder.util.exception;

import com.demo.bbq.support.exception.model.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@AllArgsConstructor
@Getter
public enum ExceptionCatalog {

  ERROR1001("/errors/business-rules", "The requested menu order doesn't exist", HttpStatus.BAD_REQUEST);

  private final String type;
  private final String title;
  private final HttpStatus status;

  public ApiException buildException(Throwable cause) {
    return (cause instanceof ApiException)
        ? (ApiException) cause
        : ApiException.builder(this.type, this.name(), this.title, this.status)
        .build();
  }

  public ApiException buildException(String additionalMessage) {
    return ApiException.builder(this.type, this.name(), this.title + " - " + additionalMessage, this.status).build();
  }

}

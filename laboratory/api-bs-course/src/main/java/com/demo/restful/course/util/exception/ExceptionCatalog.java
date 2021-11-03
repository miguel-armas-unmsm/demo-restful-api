package com.demo.restful.course.util.exception;

import static com.demo.restful.course.util.constant.MessageConstant.NO_RECORDS_FOUND;

import com.demo.restful.course.util.exception.impl.model.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionCatalog {

  ERROR0001(NO_RECORDS_FOUND, HttpStatus.NOT_FOUND);

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

package com.demo.restful.course.util.exception.impl.util.builder;

import com.demo.restful.course.util.exception.impl.model.ApiException;
import com.demo.restful.course.util.exception.impl.model.ApiExceptionDetail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Objects;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ApiExceptionBuilder {

  private String systemCode;
  private String description;
  private HttpStatus httpStatus;
  private final Map<String, Object> properties = new HashMap<>();
  private final List<ApiExceptionDetail> exceptionDetails = new ArrayList<>();
  private Throwable cause;

  public List<ApiExceptionDetail> getExceptionDetails() {
    return this.exceptionDetails;
  }

  public ApiExceptionBuilder systemCode(String systemCode) {
    Optional.ofNullable(systemCode)
        .filter(StringUtils::isNotBlank)
        .ifPresent(actualSystemCode -> this.systemCode = actualSystemCode);

    return this;
  }

  public ApiExceptionBuilder description(String description) {
    Optional.ofNullable(description)
        .filter(StringUtils::isNotBlank)
        .ifPresent(actualDescription -> this.description = actualDescription);

    return this;
  }

  public ApiExceptionBuilder httpStatus(HttpStatus httpStatus) {
    Optional.ofNullable(httpStatus)
        .ifPresent(actualHttpStatus -> this.httpStatus = actualHttpStatus);

    return this;
  }

  public ApiExceptionBuilder addProperty(String key, Object value) {
    Optional.ofNullable(key)
        .filter(StringUtils::isNotBlank)
        .filter(StringUtils::isAsciiPrintable)
        .ifPresent(actualKey -> Optional.ofNullable(value)
            .ifPresent(actualValue -> this.properties.put(actualKey, actualValue)));

    return this;
  }

  public ApiExceptionDetailBuilder addDetail() {
    return new ApiExceptionDetailBuilder(this);
  }

  public ApiExceptionBuilder cause(Throwable cause) {
    this.cause = cause;
    return this;
  }

  public ApiException build() {
    if (Objects.nonNull(this.cause)) {
      if (this.cause instanceof ApiException) {
        ((ApiException)this.cause).getExceptionDetails().forEach(detail -> this.addDetail()
            .withCode(detail.getCode())
            .withComponent(detail.getComponent())
            .withDescription(detail.getDescription()));
        this.cause((Throwable)null); // por qué? probar quitando
      } else {
        this.addDetail()
            .withComponent("Nombre de la api")
            .withDescription(this.cause.getClass().getName().concat(Optional.ofNullable(this.cause.getMessage())
                .map(" : "::concat).orElse(StringUtils.EMPTY)))
            .push();
        this.cause((Throwable)null);
      }
    }

    return new ApiException(this.systemCode, this.description, this.httpStatus,
      this.exceptionDetails.stream().collect(Collectors.toUnmodifiableList()), this.properties, this.cause);
  }

}

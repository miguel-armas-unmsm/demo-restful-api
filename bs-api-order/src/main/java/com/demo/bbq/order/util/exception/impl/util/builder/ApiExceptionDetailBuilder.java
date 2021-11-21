package com.demo.bbq.order.util.exception.impl.util.builder;

import com.demo.bbq.order.util.exception.impl.model.ApiExceptionDetail;
import org.apache.commons.lang3.StringUtils;
import java.util.Optional;

public class ApiExceptionDetailBuilder {

  private String code;
  private String component;
  private String description;

  private final ApiExceptionBuilder builder;

  public ApiExceptionDetailBuilder(ApiExceptionBuilder builder) {
    this.builder = builder;
  }

  public ApiExceptionDetailBuilder withCode(String code) {
    Optional.ofNullable(code)
        .filter(StringUtils::isNotBlank)
        .ifPresent(actualCode -> this.code = actualCode);

    return this;
  }

  public ApiExceptionDetailBuilder withComponent(String component) {
    Optional.ofNullable(component)
        .filter(StringUtils::isNotBlank)
        .ifPresent(actualComponent -> this.component = actualComponent);

    return this;
  }

  public ApiExceptionDetailBuilder withDescription(String description) {
    Optional.ofNullable(description)
        .filter(StringUtils::isNotBlank)
        .ifPresent(actualDescription -> this.description = actualDescription);

    return this;
  }

  public ApiExceptionBuilder push() {
    if (StringUtils.isNotBlank(this.code)
        || StringUtils.isNotBlank(this.component)
        || StringUtils.isNotBlank(this.description)) {

      this.builder.getExceptionDetails().add(new ApiExceptionDetail(this.code, this.component, this.description));
      this.code = null;
      this.component = null;
      this.description = null;
    }

    return this.builder;
  }

}

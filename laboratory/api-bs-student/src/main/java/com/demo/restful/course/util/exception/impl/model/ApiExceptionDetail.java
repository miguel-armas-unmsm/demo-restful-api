package com.demo.restful.course.util.exception.impl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
@AllArgsConstructor
public final class ApiExceptionDetail implements Serializable {

  @JsonProperty("code")
  private String code;

  @JsonProperty("component")
  private String component;

  @JsonProperty("description")
  private String description;

}

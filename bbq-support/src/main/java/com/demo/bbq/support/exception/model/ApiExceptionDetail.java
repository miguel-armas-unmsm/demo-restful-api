package com.demo.bbq.support.exception.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
@AllArgsConstructor
public class ApiExceptionDetail implements Serializable {

  @ApiModelProperty(notes = "A human-readable explanation specific to this occurrence of the problem")
  private String title;

  @ApiModelProperty(notes = "The component where the error is coming from")
  private String component;

}

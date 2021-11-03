package com.demo.restful.course.util.exception.impl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;


/**
 * <br/>Clase Dto que define el modelo de objeto para transmitir información
 * de la excepción personalizada.<br/>
 *
 * <b>Class</b>: ApiExceptionDto<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Oct, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Getter
@Builder
public class ApiExceptionDto implements Serializable {

  @JsonProperty(value = "systemCode", required = true)
  private String systemCode;

  @JsonProperty(value = "description", required = true)
  private String description;

  @JsonProperty(value = "httpStatus", required = true)
  private String httpStatus;

  @JsonProperty("exceptionDetails")
  private List<ApiExceptionDetail> exceptionDetails;

  @JsonProperty("properties")
  private Map<String, Object> properties;

  /**
   * Método builder que construye un objeto ApiExceptionDto base, con los campos obligatorios.
   *
   * @param systemCode código de error definido para el sistema.
   * @param description descripción del error.
   * @param httpStatus código de estado HTTP.
   * @return ApiExceptionDtoBuilder
   */
  public static ApiExceptionDtoBuilder builder(String systemCode, String description, String httpStatus) {
    return new ApiExceptionDtoBuilder()
        .systemCode(systemCode)
        .description(description)
        .httpStatus(httpStatus);
  }

}

package com.demo.restful.course.util.exception.impl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * <br/>Clase modelo que define el objeto de excepción personalizada.<br/>
 *
 * <b>Class</b>: ApiException<br/>
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
@Builder
@Getter
@Setter
public class ApiException extends RuntimeException {

  @JsonProperty(value = "systemCode", required = true)
  private String systemCode;

  @JsonProperty(value = "description", required = true)
  private String description;

  @JsonProperty(value = "httpStatus", required = true)
  private HttpStatus httpStatus;

  @JsonProperty("properties")
  private Map<String, Object> properties;

  @JsonProperty("exceptionDetails")
  private List<ApiExceptionDetail> exceptionDetails;

  @JsonProperty("cause")
  private Throwable cause;

  /**
   * Método builder que construye un objeto ApiException base, con los campos obligatorios.
   *
   * @param systemCode código de error definido para el sistema.
   * @param description descripción del error.
   * @param httpStatus código de estado HTTP.
   * @return ApiExceptionBuilder
   */
  public static ApiExceptionBuilder builder(String systemCode, String description, HttpStatus httpStatus) {
    return new ApiExceptionBuilder()
        .systemCode(systemCode)
        .description(description)
        .httpStatus(httpStatus);
  }

}

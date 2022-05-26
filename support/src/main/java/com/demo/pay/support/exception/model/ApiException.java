package com.demo.pay.support.exception.model;

import com.demo.pay.support.exception.util.builder.ApiExceptionBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
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
@Getter
@Setter
public class ApiException extends RuntimeException {

  @JsonProperty(value = "systemCode")
  private String systemCode;

  @JsonProperty(value = "description")
  private String description;

  @JsonProperty(value = "httpStatus")
  private HttpStatus httpStatus;

  @JsonProperty("properties")
  private Map<String, Object> properties;

  @JsonProperty("exceptionDetails")
  private List<ApiExceptionDetail> exceptionDetails;

  @JsonProperty("cause")
  private Throwable cause;

  public ApiException(String systemCode, String description, HttpStatus httpStatus,
                      List<ApiExceptionDetail> exceptionDetails, Map<String, Object> properties,
                      Throwable cause) {

    super(description, cause);
    this.systemCode = systemCode;
    this.description = description;
    this.httpStatus = httpStatus;
    this.exceptionDetails = Optional.ofNullable(exceptionDetails)
        .map(Collections::unmodifiableList)
        .orElseGet(Collections::emptyList);
    this.properties = properties;
  }

  /**
   * Construye un objeto ApiException básico, con los campos obligatorios.
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

  public List<ApiExceptionDetail> getExceptionDetails() {
    if (this.getCause() instanceof ApiException) {
      List<ApiExceptionDetail> details = ((ApiException)this.getCause()).getExceptionDetails();
      List<ApiExceptionDetail> newDetails = new ArrayList<>();
      newDetails.addAll(this.exceptionDetails);
      newDetails.addAll(details);
      return Collections.unmodifiableList(newDetails);
    } else {
      return this.exceptionDetails;
    }
  }

}

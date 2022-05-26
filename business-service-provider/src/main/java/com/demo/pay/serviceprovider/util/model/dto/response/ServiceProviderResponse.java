package com.demo.pay.serviceprovider.util.model.dto.response;

import com.demo.pay.serviceprovider.util.constant.RegexConstant;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información
 * del contexto ServiceProvider.<br/>
 *
 * <b>Class</b>: OrderDto<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderResponse implements Serializable {

  @NotNull(message = "id cannot be null")
  private Long id;

  @Size(min = 1, max = 50)
  @Pattern(regexp = RegexConstant.ANY_STRING)
  @NotNull(message = "name cannot be null")
  private String name;

  @Size(min = 1, max = 50)
  @Pattern(regexp = RegexConstant.ANY_STRING)
  @NotNull(message = "short name cannot be null")
  private String shortName;

  @Size(min = 1, max = 50)
  @Pattern(regexp = RegexConstant.ANY_STRING)
  @NotNull(message = "trade name cannot be null")
  private String tradeName;

  @NotNull(message = "start date cannot be null")
  private String startDate;

  @NotNull(message = "is active flag cannot be null")
  private Boolean isActive;
}
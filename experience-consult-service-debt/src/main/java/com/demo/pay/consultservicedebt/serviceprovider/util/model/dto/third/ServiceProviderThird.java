package com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.third;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.demo.pay.consultservicedebt.util.constant.RegexConstant;
import lombok.*;

/**
 * <br/>Clase DT0 que define el modelo de objeto que se consume desde el exterior
 * para contexto Service Provider.<br/>
 *
 * <b>Class</b>: ServiceProviderThird<br/>
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
public class ServiceProviderThird implements Serializable {

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
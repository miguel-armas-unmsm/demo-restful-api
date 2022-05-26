package com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.response;

import com.demo.pay.consultservicedebt.util.constant.RegexConstant;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.*;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información
 * del contexto Service Provider.<br/>
 *
 * <b>Class</b>: ServiceProviderDto<br/>
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
  @NotNull(message = "trade name cannot be null")
  private String tradeName;

}

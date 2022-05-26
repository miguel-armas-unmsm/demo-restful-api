package com.demo.pay.consultservicedebt.servicebill.util.model.dto.response;

import com.demo.pay.consultservicedebt.util.constant.RegexConstant;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información
 * del contexto Service Bill.<br/>
 *
 * <b>Class</b>: ServiceBillResponse<br/>
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
public class ServiceBillResponse implements Serializable {

  @NotNull(message = "id cannot be null")
  private Long id;

  @Size(min = 1, max = 50)
  @Pattern(regexp = RegexConstant.ANY_STRING)
  @NotNull(message = "description cannot be null")
  private String description;

  @NotNull(message = "amount cannot be null")
  private BigDecimal amount;

  @NotNull(message = "expiration date cannot be null")
  private String expirationDate;

  @NotNull(message = "consumer code cannot be null")
  private String consumerCode;

  @NotNull(message = "currency code cannot be null")
  private String currency;
}

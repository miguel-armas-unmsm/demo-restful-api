package com.demo.pay.consultservicedebt.providedservice.util.model.dto.third;

import com.demo.pay.consultservicedebt.util.constant.RegexConstant;

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
 * del contexto Account.<br/>
 *
 * <b>Class</b>: AccountDto<br/>
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
public class AccountThird implements  Serializable{

  @Size(min = 1, max = 50)
  @Pattern(regexp = RegexConstant.ACCOUNT_NUMBER)
  @NotNull(message = "account number cannot be null")
  private String accountNumber;

  @Size(min = 3, max = 3)
  @Pattern(regexp = RegexConstant.CURRENCY)
  @NotNull(message = "currency cannot be null")
  private String currency;
}

package com.demo.pay.consultservicedebt.accountholder.util.model.dto.response;

import com.demo.pay.consultservicedebt.util.constant.RegexConstant;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información
 * del contexto Account Holder.<br/>
 *
 * <b>Class</b>: AccountHolderResponse<br/>
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
public class AccountHolderResponse implements Serializable {

  @NotNull(message = "id cannot be null")
  private Long id;

  @Size(min = 1, max = 50)
  @Pattern(regexp = RegexConstant.ANY_STRING)
  @NotNull(message = "name cannot be null")
  private String name;

  @NotNull(message = "account cannot be null")
  private AccountResponse account;

}
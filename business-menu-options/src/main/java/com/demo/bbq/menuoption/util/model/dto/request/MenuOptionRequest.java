package com.demo.bbq.menuoption.util.model.dto.request;

import com.demo.bbq.menuoption.util.constant.RegexConstant;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información
 * del contexto Menu Option.<br/>
 *
 * <b>Class</b>: MenuOptionRequest<br/>
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
public class MenuOptionRequest implements Serializable {

  @Pattern(regexp = RegexConstant.ANY_STRING)
  @Size(min = 3, max = 300)
  @NotNull(message = "name cannot be null")
  private String name;

  @Pattern(regexp = RegexConstant.ANY_STRING)
  @Size(min = 3, max = 300)
  @NotNull(message = "category cannot be null")
  private String category;

  @NotNull(message = "price cannot be null")
  private BigDecimal price;

  @NotNull(message = "is active cannot be null")
  private boolean isActive;

}
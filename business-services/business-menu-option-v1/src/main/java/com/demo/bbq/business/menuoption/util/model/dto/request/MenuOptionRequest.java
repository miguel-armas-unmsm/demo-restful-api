package com.demo.bbq.business.menuoption.util.model.dto.request;

import com.demo.bbq.business.menuoption.util.constant.CustomRegexConstant;
import com.demo.bbq.support.constant.RegexConstant;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información del contexto Menu Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuOptionRequest implements Serializable {

  @Pattern(regexp = RegexConstant.ANY_STRING, message = "Name has invalid format")
  @Size(min = 3, max = 300)
  @NotNull(message = "description cannot be null")
  private String description;

  @Pattern(regexp = CustomRegexConstant.MENU_OPTION_CATEGORY, message = "Invalid menu option category")
  @NotNull(message = "category cannot be null")
  private String category;

  @NotNull(message = "price cannot be null")
  private BigDecimal price;

  @NotNull(message = "is active cannot be null")
  private boolean isActive;

}
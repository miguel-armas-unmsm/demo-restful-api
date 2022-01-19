package com.demo.bbq.order.model.dto;

import com.demo.bbq.order.util.constant.RegexConstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <br/>Clase Dto que define el modelo de objeto para transmitir información
 * del contexto MenuItem.<br/>
 *
 * <b>Class</b>: MenuItemDto<br/>
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
public class MenuItemDto implements Serializable {

  @JsonProperty("number")
//  @NotNull(message = "number cannot be null")
  private int number;

  @JsonProperty(value = "name")
//  @Pattern(regexp = RegexConstant.ANY_STRING)
//  @Size(min = 5, max = 300)
//  @NotNull(message = "name cannot be null")
  private String name;

  @JsonProperty("categoryCode")
//  @NotNull(message = "categoryCode cannot be null")
  private String categoryCode;

  @JsonProperty(value = "price")
//  @NotNull(message = "price cannot be null")
  private float price;

  @JsonProperty(value = "quantity")
//  @NotNull(message = "quantity cannot be null")
  private int quantity;

}
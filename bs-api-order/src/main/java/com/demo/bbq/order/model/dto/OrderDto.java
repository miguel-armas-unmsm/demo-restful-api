package com.demo.bbq.order.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <br/>Clase Dto que define el modelo de objeto para transmitir información
 * del contexto Order.<br/>
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
public class OrderDto implements Serializable {

  @JsonProperty("id")
  @NotNull(message = "id cannot be null")
  private Long id;

  @JsonProperty(value = "number")
  @Size(min = 1, max = 2)
  @NotNull(message = "number cannot be null")
  private String number;

  @JsonProperty(value = "statusCode")
  @NotNull(message = "statusCode cannot be null")
  private String statusCode;

  @JsonProperty(value = "date")
  @NotNull(message = "date cannot be null")
  private String date;

  @JsonProperty(value = "menuItemList")
  @NotNull(message = "menuItemList cannot be null")
  private List<MenuItemDto> menuItemList;
}
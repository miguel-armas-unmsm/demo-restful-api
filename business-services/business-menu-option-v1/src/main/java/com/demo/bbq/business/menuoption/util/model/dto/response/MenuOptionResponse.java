package com.demo.bbq.business.menuoption.util.model.dto.response;

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
public class MenuOptionResponse implements Serializable {

  private Long id;

  private String description;

  private String category;

  private BigDecimal price;

  private boolean active;

}
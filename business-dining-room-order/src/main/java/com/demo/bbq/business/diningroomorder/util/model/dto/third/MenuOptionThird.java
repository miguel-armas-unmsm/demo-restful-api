package com.demo.bbq.business.diningroomorder.util.model.dto.third;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;

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
public class MenuOptionThird implements Serializable {

  private Long id;

  private String name;

  private String category;

  private BigDecimal price;

  private boolean isActive;

}

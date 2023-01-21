package com.demo.bbq.business.payment.util.model.dto.third.invoice;

import lombok.*;
import java.io.Serializable;

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
public class MenuOrderThird implements Serializable {

  private Long menuOptionId;
  private Integer quantity;
}

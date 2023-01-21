package com.demo.bbq.business.payment.util.model.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;

/**
 * <br/>Clase DTO que define el modelo "opción de menú" dentro del bounded context "cocina". El cheff recibe la opción
 * de menu que debe preparar.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuOrderResponse implements Serializable {

  private String description;
  private BigDecimal price;
  private Integer quantity;
  private BigDecimal total;
}

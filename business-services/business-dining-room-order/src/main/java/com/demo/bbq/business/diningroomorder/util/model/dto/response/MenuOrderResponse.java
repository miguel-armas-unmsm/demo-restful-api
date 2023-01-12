package com.demo.bbq.business.diningroomorder.util.model.dto.response;

import lombok.*;
import java.io.Serializable;

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

  private Long menuOptionId;
  private Integer quantity;

}

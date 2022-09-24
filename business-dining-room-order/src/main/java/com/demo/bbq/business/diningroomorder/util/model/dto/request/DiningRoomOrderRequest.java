package com.demo.bbq.business.diningroomorder.util.model.dto.request;

import lombok.*;
import java.io.Serializable;
import java.util.List;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información del contexto Dining Room Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiningRoomOrderRequest implements Serializable {

  private List<MenuOptionRequest> menuOptionList;
  private Integer tableNumber;

}
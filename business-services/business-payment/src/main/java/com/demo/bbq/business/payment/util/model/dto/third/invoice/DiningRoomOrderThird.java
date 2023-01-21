package com.demo.bbq.business.payment.util.model.dto.third.invoice;

import java.io.Serializable;
import java.util.List;
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
public class DiningRoomOrderThird implements Serializable {

  private Integer tableNumber;
  private List<MenuOrderThird> menuOrderList;

}

package com.demo.bbq.business.diningroomorder.util.model.entity;

import javax.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <br/>Clase Entity que mapea la tabla menu_options de una base de datos relacional.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "dining_room_order")
public class DiningRoomOrder {

  @Id
  private String id;

  private List<MenuOption> menuOptionList;

  private Integer tableNumber;

  private Boolean isActive;

}

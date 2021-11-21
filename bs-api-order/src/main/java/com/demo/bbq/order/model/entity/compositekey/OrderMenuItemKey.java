package com.demo.bbq.order.model.entity.compositekey;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import java.io.Serializable;

/**
 * <br/>Clase que define el modelo de objeto para representar la primary key de la
 * entidad OrderMenuItem en una base de datos relacional.<br/>
 *
 * <b>Class</b>: Order<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Nov, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Setter
@Getter
@Embeddable
public class OrderMenuItemKey implements Serializable {

  @Column(name = "order_id", nullable = false)
  private Long id;

  @Column(name = "menu_item_id", nullable = false)
  private Long number;
}

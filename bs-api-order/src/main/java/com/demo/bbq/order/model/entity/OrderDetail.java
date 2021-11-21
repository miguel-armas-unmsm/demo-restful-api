package com.demo.bbq.order.model.entity;

import com.demo.bbq.order.model.entity.compositekey.OrderMenuItemKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <br/>Clase Entity que mapea la tabla order_detail de una base de datos relacional.<br/>
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
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {

  @EmbeddedId
  private OrderMenuItemKey id;

  @Column(name = "quantity")
  private int quantity;

}

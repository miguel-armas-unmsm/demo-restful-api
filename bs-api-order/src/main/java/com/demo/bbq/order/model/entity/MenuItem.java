package com.demo.bbq.order.model.entity;

import javax.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <br/>Clase Entity que mapea la tabla menu_item de una base de datos relacional.<br/>
 *
 * <b>Class</b>: MenuItem<br/>
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
@Table(name = "menu_items")
public class MenuItem {

  @Id
  @Column(name = "menu_item_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "number")
  private int number;

  @Column(name = "name")
  private String name;

  @Column(name = "category_code")
  private String categoryCode;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private float price;

  @Column(name = "is_active")
  private boolean isActive;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "menu_item_id", referencedColumnName = "menu_item_id")
  private List<OrderDetail> orderDetailList;

}

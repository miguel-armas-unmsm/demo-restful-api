package com.demo.bbq.business.menuoption.util.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <br/>Clase Entity que mapea la tabla menu_options de una base de datos relacional.<br/>
 *
 * <b>Class</b>: MenuOption<br/>
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
@Table(name = "menu_options")
public class MenuOption {

  @Id
  @Column(name = "menu_option_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "category")
  private String category;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "is_active")
  private boolean active;

}

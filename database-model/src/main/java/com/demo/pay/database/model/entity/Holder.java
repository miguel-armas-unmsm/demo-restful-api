package com.demo.pay.database.model.entity;

import lombok.*;
import javax.persistence.*;

/**
 * <br/>Clase Entity que mapea la tabla holders de una base de datos relacional.<br/>
 *
 * <b>Class</b>: Holder<br/>
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
@Table(name = "holders")
public class Holder {

  @Id
  @Column(name = "holder_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id")
  private Account account;
}

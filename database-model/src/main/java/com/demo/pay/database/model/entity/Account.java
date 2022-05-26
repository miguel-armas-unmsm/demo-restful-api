package com.demo.pay.database.model.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <br/>Clase Entity que mapea la tabla accounts de una base de datos relacional.<br/>
 *
 * <b>Class</b>: Account<br/>
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
@Table(name = "accounts")
public class Account {

  @Id
  @Column(name = "account_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "currency")
  private String currency;

  @Column(name = "account_balance")
  private BigDecimal accountBalance;

}

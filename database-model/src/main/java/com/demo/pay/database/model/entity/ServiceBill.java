package com.demo.pay.database.model.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <br/>Clase Entity que mapea la tabla service_bills de una base de datos relacional.<br/>
 *
 * <b>Class</b>: ServiceBill<br/>
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
@Table(name = "service_bills")
public class ServiceBill {

  @Id
  @Column(name = "service_bill_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "expiration_date")
  private String expirationDate;

  @Column(name = "consumer_code")
  private String consumerCode;

  @Column(name = "currency")
  private String currency;

  @Column(name = "provided_service_id")
  private Long providedServiceId;
}

package com.demo.pay.database.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * <br/>Clase Entity que mapea la tabla service_providers de una base de datos relacional.<br/>
 *
 * <b>Class</b>: ServiceProvider<br/>
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
@Table(name = "provided_services")
public class ProvidedService {

  @Id
  @Column(name = "provided_service_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "short_name")
  private String shortName;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "service_provider_id")
  private Long serviceProviderId;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "consumer_identification")
  private String consumerIdentification;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id")
  private Account account;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "provided_service_id", name = "provided_service_id")
  List<ServiceBill> serviceBillList;
}

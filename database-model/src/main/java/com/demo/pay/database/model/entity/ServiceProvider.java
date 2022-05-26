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
@Table(name = "service_providers")
public class ServiceProvider {

  @Id
  @Column(name = "service_provider_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "short_name")
  private String shortName;

  @Column(name = "trade_name")
  private String tradeName;

  @Column(name = "start_date")
  private String startDate;

  @Column(name = "is_active")
  private Boolean isActive;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "service_provider_id", name = "service_provider_id")
  private List<ProvidedService> providedServiceList;

}

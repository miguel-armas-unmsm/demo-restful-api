package com.demo.bbq.business.diningroomorder.util.model.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_options")
public class MenuOrder implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "menu_option_id") // should be unique=true
  private Long menuOptionId;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "table_id")
  private Long tableId;
}

package com.demo.bbq.business.diningroomorder.util.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuOption implements Serializable{

  private Long menuOptionId;
  private Integer quantity;

}

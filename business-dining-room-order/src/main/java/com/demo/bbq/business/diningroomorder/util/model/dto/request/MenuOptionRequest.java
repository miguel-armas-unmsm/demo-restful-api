package com.demo.bbq.business.diningroomorder.util.model.dto.request;

import java.io.Serializable;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuOptionRequest implements Serializable{

  private Long menuOptionId;
  private Integer quantity;

}

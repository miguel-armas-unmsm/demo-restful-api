package com.demo.bbq.business.payment.util.model.dto.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <br/>Clase DTO que define el modelo "opción de menú" dentro del bounded context "cocina". El cheff recibe la opción
 * de menu que debe preparar.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse implements Serializable {

  private Long id;

}
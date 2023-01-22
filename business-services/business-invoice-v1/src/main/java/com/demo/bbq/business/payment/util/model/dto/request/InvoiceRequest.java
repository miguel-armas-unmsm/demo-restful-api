package com.demo.bbq.business.payment.util.model.dto.request;

import lombok.*;
import java.io.Serializable;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información del contexto Dining Room Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest implements Serializable {

  private Integer tableNumber;

}
package com.demo.bbq.experience.consultmenuoption.util.model.dto.response;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <br/>Clase DTO que define el modelo de objeto para transmitir información
 * del contexto Menu Option.<br/>
 *
 * <b>Class</b>: MenuOptionThirdParty<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuOptionResponse implements Serializable {

  private Long id;

  private String name;

  private String category;

  private BigDecimal price;

}

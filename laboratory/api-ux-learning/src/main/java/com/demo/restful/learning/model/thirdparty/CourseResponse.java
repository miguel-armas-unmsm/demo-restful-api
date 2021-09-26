package com.demo.restful.learning.model.thirdparty;

import static com.demo.restful.learning.util.constant.RegexConstant.ANY_STRING;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Clase Response que define el modelo de objeto que representa la respuesta
 * del servidor API BS Course para el contexto Course.
 * <br/>
 *
 * <p>Interface: CourseResponse.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse implements Serializable {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("gradeId")
  private Integer gradeId;

  @JsonProperty("name")
  @Pattern(regexp = ANY_STRING)
  @Size(min = 5, max = 300)
  private String name;

  @JsonProperty("courseCode")
  @Pattern(regexp = ANY_STRING)
  @Size(min = 5, max = 300)
  private String courseCode;

  @JsonProperty("imageResource")
  private String imageResource;
}

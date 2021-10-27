package com.demo.restful.course.model.dto;

import static com.demo.restful.course.util.constant.RegexConstant.ANY_STRING;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Dto que define el modelo de objeto para transmitir información
 * del contexto Course.
 * <br/>
 *
 * <p>Interface: Course.<br/>
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
public class CourseDto implements Serializable {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  @Pattern(regexp = ANY_STRING)
  @Size(min = 5, max = 300)
  private String name;

  @JsonProperty("academicYear")
  private Integer academicYear;

  @JsonProperty("credits")
  private Integer credits;
}

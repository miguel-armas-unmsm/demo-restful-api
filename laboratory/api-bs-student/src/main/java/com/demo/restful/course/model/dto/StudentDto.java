package com.demo.restful.course.model.dto;

import static com.demo.restful.course.util.constant.RegexConstant.ANY_STRING;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <br/>Clase Dto que define el modelo de objeto para transmitir información
 * del contexto Course.<br/>
 *
 * <b>Class</b>: CourseDto<br/>
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
public class StudentDto implements Serializable {

  @JsonProperty(value = "code")
  private Long code;

  @JsonProperty(value = "name")
  @Pattern(regexp = ANY_STRING)
  @Size(min = 5, max = 300)
  private String name;

  @JsonProperty(value = "lastName")
  @Pattern(regexp = ANY_STRING)
  @Size(min = 5, max = 300)
  private String lastName;

  @JsonProperty(value = "listOfScoresByCourse")
  private List<ScoreFromCourseDto> listOfScoresByCourse;

}
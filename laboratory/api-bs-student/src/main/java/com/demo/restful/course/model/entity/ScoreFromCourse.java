package com.demo.restful.course.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <br/>Clase Entity que define el modelo de objeto para persistir datos del contexto Detalle de notas del estudiante
 * en una base de datos relacional.<br/>
 *
 * <b>Class</b>: StudentScoreDetail<br/>
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
public class ScoreFromCourse {

  private String code;

  private String course;

  private Integer score;
}

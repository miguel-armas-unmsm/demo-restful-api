package com.demo.restful.course.model.entity;

import lombok.*;
import javax.persistence.*;

/**
 * Clase Entity que define el modelo de objeto para persistir datos
 * del contexto Course en una base de datos relacional.
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
@Data
@Entity
@Table(name = "course")
public class Course {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "academic_year")
  private Integer academicYear;

  @Column(name = "credits")
  private Integer credits;
}

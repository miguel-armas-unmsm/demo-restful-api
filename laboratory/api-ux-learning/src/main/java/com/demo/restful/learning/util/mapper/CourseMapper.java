package com.demo.restful.learning.util.mapper;

import com.demo.restful.learning.model.dto.CourseDto;
import com.demo.restful.learning.model.thirdparty.CourseResponse;
import org.springframework.stereotype.Component;

/**
 * Clase Mapper que mueve la información del contexto Course
 * entre objetos de tipo Thirdparty y Dto.
 * <br/>
 *
 * <p>Class: CourseMapper.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Component
public class CourseMapper {

  public CourseDto buildDto(CourseResponse course) {

    return CourseDto.builder()
        .grade(course.getGradeId())
        .name(course.getName())
        .build();
  }

}

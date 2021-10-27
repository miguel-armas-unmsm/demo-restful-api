package com.demo.restful.course.util.mapper;

import com.demo.restful.course.model.dto.CourseDto;
import com.demo.restful.course.model.entity.Course;
import org.springframework.stereotype.Component;

/**
 * Clase Mapper que mueve la información del contexto Course
 * entre objetos de tipo Entity y Dto.
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

  public CourseDto buildDto(Course course) {

    return CourseDto.builder()
        .id(course.getId())
        .name(course.getName())
        .academicYear(course.getAcademicYear())
        .credits(course.getCredits())
        .build();
  }

  public Course buildEntity(CourseDto course) {
    return Course.builder()
        .id(course.getId())
        .name(course.getName())
        .name(course.getName())
        .academicYear(course.getAcademicYear())
        .credits(course.getCredits())
        .build();
  }
}

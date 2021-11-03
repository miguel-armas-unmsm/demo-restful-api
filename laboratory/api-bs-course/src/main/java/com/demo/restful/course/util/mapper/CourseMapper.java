package com.demo.restful.course.util.mapper;

import com.demo.restful.course.model.dto.CourseDto;
import com.demo.restful.course.model.entity.Course;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <br/>Clase Mapper que mueve la información del contexto Course entre objetos
 * de tipo Entity y Dto.<br/>
 *
 * <b>Class</b>: CourseMapper<br/>
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
public class CourseMapper {

  public static Function<Course, CourseDto> buildDto = course -> CourseDto.builder()
      .id(course.getId())
      .name(course.getName())
      .academicYear(course.getAcademicYear())
      .credits(course.getCredits())
      .build();

  public static Function<CourseDto, Course> buildEntity = course -> Course.builder()
      .id(course.getId())
      .name(course.getName())
      .academicYear(course.getAcademicYear())
      .credits(course.getCredits())
      .build();

  public static BiFunction<CourseDto, CourseDto, CourseDto> buildUpdatedCourse = (courseFound, courseUpdate) -> {
    courseFound.setName(courseUpdate.getName());
    courseFound.setAcademicYear(courseUpdate.getAcademicYear());
    courseFound.setCredits(courseUpdate.getCredits());
    return courseFound;
  };

  public static Function<Long, URI> buildUriLocation = id -> ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();
}

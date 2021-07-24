package com.apprende.business.course.util.builder;

import com.apprende.business.course.model.dto.CourseDto;
import com.apprende.business.course.model.entity.Course;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase transformadora de objetos Module.<br/>
 * <b>Class</b>: ModuleMapper<br/>
 *
 * @author Miguel Armas Abt <br/>
 *     <u>Developed by</u>: Miguel Armas Abt <br/>
 *     <ul>
 *     </ul>
 *     <u>Changes</u>:<br/>
 *     <ul>
 *     <li>Abr, 2021 Creaci&oacute;n de Clase.</li>
 *     </ul>
 * @version 1.0
 */
@Component
public class CourseBuilder {

  /**
   * Este método transforma un objeto Course tipo entity
   * a uno tipo DTO.
   *
   * @param course Course tipo entity.
   * @return Course tipo DTO.
   */
  public CourseDto builderDto(Course course) {

    return CourseDto.builder()
            .id(course.getId())
            .gradeId(course.getGradeId())
            .name(course.getName())
            .courseCode(course.getCourseCode())
            .imageResource(course.getImageResource())
            .build();
  }

  /**
   * Este método transforma un objeto Course tipo DTO
   * a uno tipo entity.
   *
   * @param course Course tipo DTO.
   * @return Course tipo entity.
   */
  public Course builderEntity(CourseDto course) {

    return Course.builder()
            .id(course.getId())
            .gradeId(course.getGradeId())
            .name(course.getName())
            .courseCode(course.getCourseCode())
            .imageResource(course.getImageResource())
            .build();
  }
}

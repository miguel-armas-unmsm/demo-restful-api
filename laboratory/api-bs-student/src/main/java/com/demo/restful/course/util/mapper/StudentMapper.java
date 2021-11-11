package com.demo.restful.course.util.mapper;

import com.demo.restful.course.model.dto.ScoreFromCourseDto;
import com.demo.restful.course.model.dto.StudentDto;
import com.demo.restful.course.model.entity.ScoreFromCourse;
import com.demo.restful.course.model.entity.Student;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <br/>Clase Mapper que mueve la información del contexto Course entre objetos
 * de tipo Entity y Dto.<br/>
 *
 * <b>Class</b>: CourseMapper<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Miguel Armas Abt</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Clase.</li>
 * </ul>
 * @version 1.0
 */
public class StudentMapper {

  public static BiFunction<Student, List<ScoreFromCourseDto>, StudentDto> buildStudentWithScores =
      (student, listOfScoresByCourse) -> StudentDto.builder()
          .code(student.getCode())
          .name(student.getName())
          .lastName(student.getLastName())
          .listOfScoresByCourse(listOfScoresByCourse)
          .build();

  public static Function<ScoreFromCourse, ScoreFromCourseDto> buildScoreFromCourse = scoreFromCourse ->
      ScoreFromCourseDto.builder()
          .code(scoreFromCourse.getCode())
          .course(scoreFromCourse.getCourse())
          .score(scoreFromCourse.getScore())
          .build();

  public static Function<Student, StudentDto> buildStudent = student -> StudentDto.builder()
          .code(student.getCode())
          .name(student.getName())
          .lastName(student.getLastName())
          .build();
}

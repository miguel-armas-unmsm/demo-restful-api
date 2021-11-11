package com.demo.restful.course.dao.impl;

import static com.demo.restful.course.util.mapper.StudentMapper.*;

import com.demo.restful.course.dao.StudentDao;
import com.demo.restful.course.model.dto.ScoreFromCourseDto;
import com.demo.restful.course.model.dto.StudentDto;
import com.demo.restful.course.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase DAO que implementa los métodos necesarios para separar los objetos de acceso a datos
 * de los objetos de negocio del contexto Student.<br/>
 *
 * <b>Class</b>: StudentDaoImpl<br/>
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
@RequiredArgsConstructor
@Component
public class StudentDaoImpl implements StudentDao {

  private final StudentRepository repository;

  @Override
  public StudentDto findScoresByCode(Long code) {
    List<ScoreFromCourseDto> scores = repository.findScores(code)
        .stream().map(buildScoreFromCourse)
        .collect(Collectors.toList());

    return buildStudentWithScores.apply(repository.findByCode(code), scores);
  }

  @Override
  public List<StudentDto> findAll() {
    return repository.findAll().stream()
        .map(buildStudent)
        .collect(Collectors.toList());
  }

}

package com.demo.restful.course.business.impl;

import static com.demo.restful.course.util.mapper.CourseMapper.buildUpdatedCourse;

import com.demo.restful.course.business.CourseService;
import com.demo.restful.course.dao.CourseDao;
import com.demo.restful.course.model.dto.CourseDto;
import java.util.List;
import java.util.Optional;

import com.demo.restful.course.util.exception.impl.model.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Course.<br/>
 *
 * <b>Class</b>: CourseServiceImpl<br/>
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
@Service
public class CourseServiceImpl implements CourseService {

  private final CourseDao dao;

  @Override
  public List<CourseDto> findAll() {
    return dao.findAll();
  }

  @Override
  public CourseDto findById(Long id) {
    return dao.findById(id);
  }

  @Override
  public List<CourseDto> findByAcademicYear(Integer academicYear) {
    return dao.findByAcademicYear(academicYear);
  }

  @Override
  public Long save(CourseDto course) {
    return dao.save(course);
  }

  @Override
  public void update(Long id, CourseDto course) {
    Optional.of(dao.findById(id))
        .ifPresent(courseFound -> {
          buildUpdatedCourse.apply(courseFound, course);
          dao.save(courseFound);
        });
  }

  @Override
  public void deleteById(Long id) {
    Optional.of(dao.findById(id))
        .ifPresent(course -> dao.deleteById(id));
  }

}

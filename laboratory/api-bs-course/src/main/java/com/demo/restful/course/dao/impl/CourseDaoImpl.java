package com.demo.restful.course.dao.impl;

import static com.demo.restful.course.util.exception.ExceptionCatalog.ERROR0001;
import static com.demo.restful.course.util.mapper.CourseMapper.buildDto;
import static com.demo.restful.course.util.mapper.CourseMapper.buildEntity;

import com.demo.restful.course.dao.CourseDao;
import com.demo.restful.course.model.dto.CourseDto;
import com.demo.restful.course.repository.CourseRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase DAO que implementa los métodos necesarios para separar los objetos de acceso a datos
 * de los objetos de negocio del contexto Course.<br/>
 *
 * <b>Class</b>: CourseDaoImpl<br/>
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
public class CourseDaoImpl implements CourseDao {

  private final CourseRepository repository;

  @Override
  public List<CourseDto> findAll() {
    return repository.findAll().stream()
        .map(buildDto)
        .collect(Collectors.toList());
  }

  @Override
  public CourseDto findById(Long id) {
    return repository.findById(id)
        .map(buildDto)
        .orElseThrow(ERROR0001::buildException);
  }

  @Override
  public List<CourseDto> findByAcademicYear(Integer academicYear) {
    return repository.findByAcademicYear(academicYear)
        .stream()
        .map(buildDto)
        .collect(Collectors.toList());
  }

  @Override
  public Long save(CourseDto courseDto) {
    return buildDto.apply(repository.save(buildEntity.apply(courseDto))).getId();
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}

package com.demo.restful.course.dao.impl;

import com.demo.restful.course.dao.CourseDao;
import com.demo.restful.course.model.dto.CourseDto;
import com.demo.restful.course.repository.CourseRepository;
import com.demo.restful.course.util.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase DAO que implementa los métodos necesarios para separar
 * los objetos de acceso a datos de los objetos de negocio del
 * contexto Course.<br/>
 *
 * <p>Class: CourseDaoImpl.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Clase.</li>
 * </ul>
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class CourseDaoImpl implements CourseDao {

  private final CourseRepository repository;
  private final CourseMapper mapper;

  @Override
  public List<CourseDto> findAll() {
    return repository.findAll().stream()
        .map(mapper::buildDto)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<CourseDto> findById(Integer id) {
    return repository.findById(id)
        .map(mapper::buildDto);
  }

  @Override
  public List<CourseDto> findByGradeId(Integer gradeId) {
    return repository.findByGradeId(gradeId)
        .stream()
        .map(mapper::buildDto)
        .collect(Collectors.toList());
  }

  @Override
  public CourseDto save(CourseDto courseDto) {
    return mapper.buildDto(repository.save(mapper.buildEntity(courseDto)));
  }

  @Override
  public void deleteById(Integer id) {
    repository.deleteById(id);
  }

}

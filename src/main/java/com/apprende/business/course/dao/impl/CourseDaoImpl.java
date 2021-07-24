package com.apprende.business.course.dao.impl;

import com.apprende.business.course.dao.CourseDao;
import com.apprende.business.course.model.dto.CourseDto;
import com.apprende.business.course.model.entity.Course;
import com.apprende.business.course.repository.CourseRepository;
import com.apprende.business.course.util.builder.CourseBuilder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <br/> Interface de tipo DAO que contiene los metodos necesarios para
 * tramitar las conversiones de objetos de acceso a datos que consumira
 * la clase ModuleServiceImpl.<br/>
 * <b>Interface</b>: ModuleDao<br/>
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
@RequiredArgsConstructor
@Component
public class CourseDaoImpl implements CourseDao {

  private final CourseRepository repository;
  private final CourseBuilder mapper;

  @Override
  public List<CourseDto> findByGradeId(Integer gradeId) {
    return repository.findByGradeId(gradeId)
            .stream()
            .map(mapper::builderDto)
            .collect(Collectors.toList());
  }

  @Override
  public List<CourseDto> findAll() {
    return repository.findAll().stream()
            .map(mapper::builderDto)
            .collect(Collectors.toList());
  }

  @Override
  public CourseDto save(CourseDto courseDto) {
    repository.save(mapper.builderEntity(courseDto));
    return courseDto;
  }

}

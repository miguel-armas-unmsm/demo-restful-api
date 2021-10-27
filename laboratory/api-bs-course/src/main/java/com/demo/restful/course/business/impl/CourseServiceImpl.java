package com.demo.restful.course.business.impl;

import com.demo.restful.course.business.CourseService;
import com.demo.restful.course.dao.CourseDao;
import com.demo.restful.course.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase Service que implementa los métodos necesarios
 * para tramitar la lógica de negocio del
 * contexto Course.<br/>
 *
 * <p>Interface: CourseServiceImpl.<br/>
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
@Service
public class CourseServiceImpl implements CourseService {

  private final CourseDao dao;

  @Override
  public List<CourseDto> findAll() {
    return dao.findAll();
  }

  @Override
  public Optional<CourseDto> findById(Integer id) {
    return dao.findById(id);
  }

  @Override
  public List<CourseDto> findByAcademicYear(Integer academicYear) {
    return dao.findByAcademicYear(academicYear);
  }

  @Override
  public CourseDto save(CourseDto courseDto) {
    return dao.save(courseDto);
  }

  @Override
  public void deleteById(Integer id) {
    if (dao.findById(id).isPresent())
      dao.deleteById(id);
  }

}

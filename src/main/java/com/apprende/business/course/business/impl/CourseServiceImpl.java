package com.apprende.business.course.business.impl;

import com.apprende.business.course.business.CourseService;
import com.apprende.business.course.dao.CourseDao;
import com.apprende.business.course.model.dto.CourseDto;
import com.apprende.business.course.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <br/> Clase de tipo Service que contiene los metodos necesarios para
 * tramitar la logica de negocio que consumira la clase REST ModuleController.<br/>
 * <b>Class</b>: ModuleServiceImpl<br/>
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
  public List<CourseDto> findByGradeId(Integer gradeId) {
    return dao.findByGradeId(gradeId);
  }

  @Override
  public CourseDto save(CourseDto courseDto) {
    return dao.save(courseDto);
  }

  @Override
  public void deleteById(Integer id) {
    if (dao.findById(id).isPresent())
      dao.deleteById(id);
    else
      throw new NotFoundException(new StringBuffer()
              .append("Course with id ")
              .append(id)
              .append(" not found").toString());
  }
}

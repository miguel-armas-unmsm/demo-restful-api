package com.apprende.business.course.business.impl;

import com.apprende.business.course.business.CourseService;
import com.apprende.business.course.dao.CourseDao;
import com.apprende.business.course.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
  public List<CourseDto> findByGradeId(Integer gradeId) {
    return dao.findByGradeId(gradeId);
  }

  @Override
  public List<CourseDto> findAll() {
    return dao.findAll();
  }

  @Override
  public CourseDto save(CourseDto courseDto) {
    return dao.save(courseDto);
  }
}

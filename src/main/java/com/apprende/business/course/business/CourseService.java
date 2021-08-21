package com.apprende.business.course.business;

import com.apprende.business.course.model.dto.CourseDto;
import com.apprende.business.course.util.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * <br/> Interface de tipo Service que contiene los metodos necesarios para
 * tramitar la logica de negocio que consumira la clase REST ModuleController.<br/>
 * <b>Interface</b>: ModuleService<br/>
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
public interface CourseService {

  List<CourseDto> findAll();
  Optional<CourseDto> findById(Integer id);
  List<CourseDto> findByGradeId(Integer gradeId);
  CourseDto save(CourseDto courseDto);
  void deleteById(Integer id) throws NotFoundException;
}

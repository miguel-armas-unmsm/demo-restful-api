package com.apprende.business.course.business;

import com.apprende.business.course.model.dto.CourseDto;
import java.util.List;

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

  List<CourseDto> findByGradeId(Integer gradeId);
  List<CourseDto> findAll();
  CourseDto save(CourseDto courseDto);
}

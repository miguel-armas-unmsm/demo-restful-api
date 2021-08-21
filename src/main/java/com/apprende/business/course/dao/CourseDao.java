package com.apprende.business.course.dao;

import com.apprende.business.course.model.dto.CourseDto;
import java.util.List;
import java.util.Optional;

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
public interface CourseDao {

  List<CourseDto> findAll();
  Optional<CourseDto> findById(Integer id);
  List<CourseDto> findByGradeId(Integer gradeId);
  CourseDto save(CourseDto courseDto);
  void deleteById(Integer id);
}

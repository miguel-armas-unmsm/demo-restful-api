package com.demo.restful.course.dao;

import com.demo.restful.course.model.dto.CourseDto;
import java.util.List;
import java.util.Optional;

/**
 * <br/>Interface DAO que define los métodos necesarios para separar los objetos de acceso a datos
 * de los objetos de negocio del contexto Course.<br/>
 *
 * <b>Class</b>: CourseDao<br/>
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
public interface CourseDao {

  List<CourseDto> findAll();

  Optional<CourseDto> findById(Long id);

  List<CourseDto> findByAcademicYear(Integer academicYear);

  Long save (CourseDto courseDto);

  void deleteById(Long id);
}

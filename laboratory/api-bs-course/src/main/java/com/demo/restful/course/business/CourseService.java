package com.demo.restful.course.business;

import com.demo.restful.course.model.dto.CourseDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface Service que define los métodos necesarios
 * para tramitar la lógica de negocio del
 * contexto Course.<br/>
 *
 * <p>Interface: CourseService.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Interface.</li>
 * </ul>
 * @version 1.0
 */
public interface CourseService {

  List<CourseDto> findAll();

  Optional<CourseDto> findById(Long id);

  List<CourseDto> findByAcademicYear(Integer academicYear);

  CourseDto save(CourseDto courseDto);

  void deleteById(Long id);
}

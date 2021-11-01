package com.demo.restful.course.repository;

import com.demo.restful.course.model.entity.Course;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Course.<br/>
 *
 * <b>Interface</b>: CourseRepository<br/>
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
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

  List<Course> findAll();

  List<Course> findByAcademicYear(Integer academicYear);

  Optional<Course> findById(Long id);

  Course save(Course course);

  void deleteById(Long id);
}
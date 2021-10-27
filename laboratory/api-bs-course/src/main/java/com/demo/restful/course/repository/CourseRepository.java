package com.demo.restful.course.repository;

import com.demo.restful.course.model.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface Repository que define los métodos necesarios para acceder
 * a los datos del contexto Course.<br/>
 *
 * <p>Interface: CourseRepository.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Interface.</li>
 * </ul>
 * @version 1.0
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

  List<Course> findAll();

  Optional<Course> findById(Long id);

  List<Course> findByAcademicYear(Integer academicYear);

  Course save(Course course);

  void deleteById(Long id);
}

package com.apprende.business.course.repository;

import com.apprende.business.course.model.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface de tipo Repository para acceso a la tabla public.class_module.
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

  List<Course> findAll();
  Optional<Course> findById(Integer id);
  List<Course> findByGradeId(Integer gradeId);
  Course save(Course course);
  void deleteById(Integer id);
}

package com.apprende.business.course.repository;

import com.apprende.business.course.model.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de tipo Repository para acceso a la tabla public.class_module.
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

  List<Course> findByGradeId(Integer gradeId);
  List<Course> findAll();
  Course findById(Integer id);
  Course save(Course course);
}

package com.demo.restful.course.repository;

import com.demo.restful.course.model.entity.Student;
import com.demo.restful.course.model.entity.ScoreFromCourse;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Student.<br/>
 *
 * <b>Interface</b>: StudentRepository<br/>
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
public interface StudentRepository {

  List<ScoreFromCourse> findScores(Long studentCode);

  List<Student> findAll();

  Student findByCode(Long code);

}
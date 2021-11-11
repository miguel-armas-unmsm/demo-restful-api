package com.demo.restful.course.business;

import com.demo.restful.course.model.dto.StudentDto;

import java.util.List;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio
 * del contexto Course.<br/>
 *
 * <b>Interface</b>: CourseService<br/>
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
public interface StudentService {

  StudentDto findScoresByCode(Long code);

  List<StudentDto> findAll();
}

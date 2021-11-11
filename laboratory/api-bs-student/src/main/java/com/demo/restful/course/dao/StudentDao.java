package com.demo.restful.course.dao;

import com.demo.restful.course.model.dto.StudentDto;
import java.util.List;

/**
 * <br/>Interface DAO que define los métodos necesarios para separar los objetos de acceso a datos
 * de los objetos de negocio del contexto Student.<br/>
 *
 * <b>Class</b>: StudentDao<br/>
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
public interface StudentDao {

  StudentDto findScoresByCode(Long code);

  List<StudentDto> findAll();
}

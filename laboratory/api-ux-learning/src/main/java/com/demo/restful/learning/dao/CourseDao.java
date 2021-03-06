package com.demo.restful.learning.dao;

import com.demo.restful.learning.model.dto.CourseDto;
import java.util.List;

/**
 * Interface DAO que define los métodos necesarios para separar
 * los objetos de acceso a datos de los objetos de negocio del
 * contexto Course.<br/>
 *
 * <p>Interface: CourseDao.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Interface.</li>
 * </ul>
 * @version 1.0
 */
public interface CourseDao {

  List<CourseDto> findAll();

}

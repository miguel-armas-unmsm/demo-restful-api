package com.demo.restful.learning.business;

import com.demo.restful.learning.model.dto.CourseDto;
import java.util.List;

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
}

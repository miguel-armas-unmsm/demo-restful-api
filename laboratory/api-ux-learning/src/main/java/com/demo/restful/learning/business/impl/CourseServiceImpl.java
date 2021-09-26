package com.demo.restful.learning.business.impl;

import com.demo.restful.learning.business.CourseService;
import com.demo.restful.learning.dao.CourseDao;
import com.demo.restful.learning.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase Service que implementa los métodos necesarios
 * para tramitar la lógica de negocio del
 * contexto Course.<br/>
 *
 * <p>Interface: CourseServiceImpl.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Clase.</li>
 * </ul>
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

  private final CourseDao dao;

  @Override
  public List<CourseDto> findAll() {
    return dao.findAll();
  }

}

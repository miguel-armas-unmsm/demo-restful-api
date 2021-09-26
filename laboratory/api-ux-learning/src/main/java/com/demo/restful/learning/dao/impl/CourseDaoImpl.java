package com.demo.restful.learning.dao.impl;

import com.demo.restful.learning.client.proxy.contract.CourseApi;
import com.demo.restful.learning.dao.CourseDao;
import com.demo.restful.learning.model.dto.CourseDto;
import com.demo.restful.learning.util.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase DAO que implementa los métodos necesarios para separar
 * los objetos de acceso a datos de los objetos de negocio del
 * contexto Course.<br/>
 *
 * <p>Class: CourseDaoImpl.<br/>
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
@Component
public class CourseDaoImpl implements CourseDao {

  private final CourseApi courseApi;
  private final CourseMapper mapper;

  @Override
  public List<CourseDto> findAll() {
    return courseApi.findAll().blockingFirst()
        .stream()
        .map(mapper::buildDto)
        .collect(Collectors.toList());
  }

}

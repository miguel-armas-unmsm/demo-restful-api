package com.demo.restful.course.business.impl;

import com.demo.restful.course.business.StudentService;
import com.demo.restful.course.dao.StudentDao;
import com.demo.restful.course.model.dto.StudentDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Course.<br/>
 *
 * <b>Class</b>: CourseServiceImpl<br/>
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
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentDao dao;

  @Override
  public StudentDto findScoresByCode(Long code) {
    return dao.findScoresByCode(code);
  }

  @Override
  public List<StudentDto> findAll() {
    return dao.findAll();
  }

}

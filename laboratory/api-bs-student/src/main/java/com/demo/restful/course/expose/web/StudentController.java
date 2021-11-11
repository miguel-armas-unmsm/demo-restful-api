package com.demo.restful.course.expose.web;

import com.demo.restful.course.business.StudentService;
import com.demo.restful.course.model.dto.StudentDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST
 * los servicios del contexto Course.<br/>
 *
 * <b>Class</b>: CourseController<br/>
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
@RestController
@RequestMapping("/demo/business/v1/students")
public class StudentController {

  private final StudentService service;

  @GetMapping(produces = "application/json", value = "/{code}")
  public ResponseEntity<StudentDto> findById(@PathVariable(name = "code") Long code) {

    return ResponseEntity.ok(service.findScoresByCode(code));
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<StudentDto>> findAll() {

    return ResponseEntity.ok(service.findAll());
  }

}

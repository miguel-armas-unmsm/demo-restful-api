package com.demo.restful.learning.expose.web;

import com.demo.restful.learning.business.CourseService;
import com.demo.restful.learning.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Clase Controller que implementa los métodos necesarios
 * para exponer mediante REST los servicios del
 * contexto Course.<br/>
 *
 * <p>Interface: CourseController.<br/>
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
@RestController
@RequestMapping("demo/experience/v1/")
public class CourseController {

  private final CourseService service;

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<CourseDto>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

}














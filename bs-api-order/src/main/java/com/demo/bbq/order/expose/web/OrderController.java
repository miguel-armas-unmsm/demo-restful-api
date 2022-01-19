package com.demo.bbq.order.expose.web;


import com.demo.bbq.order.business.OrderService;
import com.demo.bbq.order.model.dto.OrderDto;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.bbq.order.util.mapper.CommonMapper.buildUriLocation;

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
@RequestMapping("/bbq/business/v1/orders")
public class OrderController {

  private final OrderService service;

  @GetMapping(produces = "application/json", value = "/{id}")
  public ResponseEntity<OrderDto> findById(@PathVariable(name = "id") Long id) {

    return ResponseEntity.ok(service.findById(id));
  }

  /**
   * Método que retorna una lista de curos filtrados por año académico.
   *
   * @param academicYear año académico.
   * @return lista de cursos.
   */
  @GetMapping(produces = "application/json")
  public ResponseEntity<List<OrderDto>> findByAcademicYear(
      @RequestParam(value = "academicYear", required = false) Integer academicYear) {

//    List<OrderDto> courses = Optional.ofNullable(academicYear).isEmpty()
//        ? service.findAll()
//        : service.findByAcademicYear(academicYear);

    return ResponseEntity.ok(service.findAll());
  }

  /**
   * Método que guarda un registro de curso.
   *
   * @param course curos a guardar.
   * @return sin contenido.
   */
  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody OrderDto course) {

    Long id = service.save(course);
    return ResponseEntity.created(buildUriLocation.apply(id)).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@Valid @RequestBody OrderDto course, @PathVariable("id") Long id) {

    service.update(id, course);
    return ResponseEntity.created(buildUriLocation.apply(course.getId())).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}

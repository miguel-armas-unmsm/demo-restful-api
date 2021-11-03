package com.demo.restful.course.expose.web;

import static com.demo.restful.course.util.mapper.CourseMapper.buildUriLocation;

import com.demo.restful.course.business.CourseService;
import com.demo.restful.course.model.dto.CourseDto;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/demo/business/v1/courses")
public class CourseController {

  private final CourseService service;

  @GetMapping(produces = "application/json", value = "/{id}")
  public ResponseEntity<CourseDto> findById(@PathVariable(name = "id") Long id) {

    return ResponseEntity.ok(service.findById(id));
  }

  /**
   * Método que retorna una lista de curos filtrados por año académico.
   *
   * @param academicYear año académico.
   * @return lista de cursos.
   */
  @GetMapping(produces = "application/json")
  public ResponseEntity<List<CourseDto>> findByAcademicYear(
      @RequestParam(value = "academicYear", required = false) Integer academicYear) {

    List<CourseDto> courses = Optional.ofNullable(academicYear).isEmpty()
        ? service.findAll()
        : service.findByAcademicYear(academicYear);

    return ResponseEntity.ok(courses);
  }

  /**
   * Método que guarda un registro de curso.
   *
   * @param course curos a guardar.
   * @return sin contenido.
   */
  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody CourseDto course) {

    Long id = service.save(course);
    return ResponseEntity.created(buildUriLocation.apply(id)).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@Valid @RequestBody CourseDto course, @PathVariable("id") Long id) {

    service.update(id, course);
    return ResponseEntity.created(buildUriLocation.apply(course.getId())).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}

package com.demo.restful.course.expose.web;

import com.demo.restful.course.business.CourseService;
import com.demo.restful.course.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
@RequestMapping("demo/business/v1/courses")
public class CourseController {

  private final CourseService service;

  @GetMapping(produces = "application/json", value = "/{id}")
  public ResponseEntity<Optional<CourseDto>> findById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<CourseDto>> findByAcademicYear(@RequestParam(value = "academicYear", required = false) Integer academicYear) {
    if (academicYear == null)
      return ResponseEntity.ok(service.findAll());
    else
      return ResponseEntity.ok(service.findByAcademicYear(academicYear));
  }

  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody CourseDto courseDto) {
    CourseDto course = service.save(courseDto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(course.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseDto courseDto, @PathVariable("id") Integer id) {
    return ResponseEntity.ok(service.save(courseDto));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    service.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}














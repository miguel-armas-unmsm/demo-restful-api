package com.apprende.business.course.web;

import com.apprende.business.course.business.CourseService;
import com.apprende.business.course.model.dto.CourseDto;
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
 * <br/> Clase de tipo Controller que contiene los metodos necesarios para
 * tramitar las peticiones REST del API BS Course.<br/>
 * <b>Class</b>: CourseController<br/>
 *
 * @author Miguel Armas Abt <br/>
 *     <u>Developed by</u>: Miguel Armas Abt <br/>
 *     <ul>
 *     </ul>
 *     <u>Changes</u>:<br/>
 *     <ul>
 *     <li>Abr, 2021 Creaci&oacute;n de Clase.</li>
 *     </ul>
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("apprende/business/v1/courses")
public class CourseController {

  private final CourseService service;

  @GetMapping(produces = "application/json", value = "/{id}")
  public ResponseEntity<Optional<CourseDto>> findById(@PathVariable(name = "id") Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<CourseDto>> findByGradeId(
          @RequestParam(value = "gradeId", required = false) Integer gradeId) {
    if(gradeId == null)
      return ResponseEntity.ok(service.findAll());
    else
      return ResponseEntity.ok(service.findByGradeId(gradeId));
  }

  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody CourseDto courseDto){
    CourseDto course = service.save(courseDto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(course.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseDto courseDto,
                                          @PathVariable("id") Integer id) {
    return ResponseEntity.ok(service.save(courseDto));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
    service.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}














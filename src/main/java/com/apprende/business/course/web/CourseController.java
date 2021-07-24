package com.apprende.business.course.web;

import com.apprende.business.course.business.CourseService;
import com.apprende.business.course.model.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping(produces = "application/json", value = "/magister")
  public ResponseEntity<List<CourseDto>> findByGradeId(
          @RequestParam(value = "gradeId", required = true) Integer gradeId) {
    return ResponseEntity.ok(service.findByGradeId(gradeId));
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<CourseDto>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @PostMapping
  public void save(@RequestBody CourseDto courseDto){
    service.save(courseDto);
  }
}
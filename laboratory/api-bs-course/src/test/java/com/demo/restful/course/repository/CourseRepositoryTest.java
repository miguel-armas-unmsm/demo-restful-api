package com.demo.restful.course.repository;

import static com.demo.restful.course.util.Util.buildModelFromJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.restful.course.model.entity.Course;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Para utilizar la fuente de datos propia de la aplicación en las pruebas unitaras:
 * '@AutoConfigureTestDatabase(replace = NONE)'
 */
@DataJpaTest
class CourseRepositoryTest {

  @Autowired
  private CourseRepository repository;

  private Course expectedCourseSavedOne;
  private List<Course> expectedListSavedCourses;

  @BeforeEach
  void setup() throws IOException {

    expectedCourseSavedOne = buildModelFromJson("data/model/entity/Course.json", Course.class);
    expectedCourseSavedOne.setId(1L);

    Course expectedCourseSavedTwo = Course.builder()
        .id(2L)
        .name("Sistemas Distribuidos")
        .credits(3)
        .academicYear(9)
        .build();

    expectedListSavedCourses = new ArrayList<>();
    expectedListSavedCourses.add(expectedCourseSavedOne);
    expectedListSavedCourses.add(expectedCourseSavedTwo);
  }

  @Test
  public void findAll() {

    String expected = new Gson().toJson(expectedListSavedCourses);
    String actual = new Gson().toJson(repository.findAll());

    assertEquals(expected, actual);
  }

  @Test
  public void findById() {

    String expected = new Gson().toJson(expectedCourseSavedOne);
    String actual = new Gson().toJson(repository.findById(1L).get());

    assertEquals(expected, actual);
  }

  @Test
  public void findByAcademicYear() {

    List<Course> expectedCourses = new ArrayList<>();
    expectedCourses.add(expectedCourseSavedOne);

    String expected = new Gson().toJson(expectedCourses);
    String actual = new Gson().toJson(repository.findByAcademicYear(10));

    assertEquals(expected, actual);
  }

  /**
   * Para no revertir los cambios: @Rollback(value = false)
   */
  @Test
  public void save() throws IOException {

    int itemsBefore = repository.findAll().size();

    Course expectedCourse = buildModelFromJson("data/model/entity/Course.json", Course.class);
    Course actualCourse = repository.save(expectedCourse);
    expectedCourse.setId(actualCourse.getId());

    int itemsAfter = repository.findAll().size();

    String expected = new Gson().toJson(expectedCourse);
    String actual = new Gson().toJson(actualCourse);

    assertEquals(itemsBefore + 1, itemsAfter);
    assertEquals(expected, actual);
    assertNotNull(actualCourse);
    assertNotNull(actualCourse.getId());
  }

  @Test
  public void deleteById() {
    Long id = 1L;

    boolean isExistBefore = repository.findById(id).isPresent();
    repository.deleteById(1L);
    boolean isExistAfter = repository.findById(id).isPresent();

    assertTrue(isExistBefore);
    assertFalse(isExistAfter);
  }

}
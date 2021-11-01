package com.demo.restful.course.dao.impl;

import static com.demo.restful.course.util.Util.buildModelFromJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.demo.restful.course.model.dto.CourseDto;
import com.demo.restful.course.model.entity.Course;
import com.demo.restful.course.repository.CourseRepository;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class CourseDaoTest {

  @InjectMocks
  private CourseDaoImpl dao;

  @Mock
  private CourseRepository repository;

  private CourseDto expectedCourseOne;
  private List<CourseDto> expectedCourseList;
  private Course savedCourseOne;
  private List<Course> savedCourseList;

  @BeforeEach
  public void setup() throws IOException {
    MockitoAnnotations.openMocks(this);

    savedCourseOne = buildModelFromJson("data/model/entity/Course.json", Course.class);
    savedCourseOne.setId(1L);

    Course savedCourseTwo = Course.builder()
        .id(2L)
        .name("Sistemas Distribuidos")
        .credits(3)
        .academicYear(9)
        .build();

    savedCourseList = new ArrayList<>();
    savedCourseList.add(savedCourseOne);
    savedCourseList.add(savedCourseTwo);

    expectedCourseOne = buildModelFromJson("data/model/dto/CourseDto.json", CourseDto.class);
    expectedCourseOne.setId(1L);

    CourseDto expectedCourseTwo = CourseDto.builder()
        .id(2L)
        .name("Sistemas Distribuidos")
        .credits(3)
        .academicYear(9)
        .build();

    expectedCourseList = new ArrayList<>();
    expectedCourseList.add(expectedCourseOne);
    expectedCourseList.add(expectedCourseTwo);
  }

  @Test
  public void findAll() {
    when(repository.findAll()).thenReturn(savedCourseList);

    String expected = new Gson().toJson(expectedCourseList);
    String actual = new Gson().toJson(dao.findAll());

    assertEquals(expected, actual);
  }

  @Test
  public void findById() {
    when(repository.findById(anyLong())).thenReturn(Optional.of(savedCourseOne));

    String expected = new Gson().toJson(expectedCourseOne);
    String actual = new Gson().toJson(dao.findById(1L).get());

    assertEquals(expected, actual);
  }

  @Test
  public void findByAcademicYear() {
    List<Course> savedCourses = new ArrayList<>();
    savedCourses.add(savedCourseOne);

    List<CourseDto> expectedCourses = new ArrayList<>();
    expectedCourses.add(expectedCourseOne);

    when(repository.findByAcademicYear(anyInt())).thenReturn(savedCourses);

    String expected = new Gson().toJson(expectedCourses);
    String actual = new Gson().toJson(dao.findByAcademicYear(10));

    assertEquals(expected, actual);
  }

  @Test
  public void save() {
    when(repository.save(any())).thenReturn(savedCourseOne);

    String expected = new Gson().toJson(expectedCourseOne.getId());
    String actual = new Gson().toJson(dao.save(expectedCourseOne));

    assertEquals(expected, actual);
  }

  @Test void delete() {
    dao.deleteById(1L);
  }

}
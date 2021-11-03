package com.demo.restful.course.business.impl;

import static com.demo.restful.course.util.Util.buildModelFromJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.demo.restful.course.dao.CourseDao;
import com.demo.restful.course.model.dto.CourseDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
class CourseServiceTest {

  @InjectMocks
  private CourseServiceImpl service;

  @Mock
  private CourseDao dao;

  private CourseDto expectedCourseOne;
  private List<CourseDto> expectedCourseList;

  @BeforeEach
  public void setup() throws IOException {
    MockitoAnnotations.openMocks(this);

    expectedCourseOne = buildModelFromJson("data/model/dto/CourseDto.json", CourseDto.class);
    expectedCourseOne.setId(1L);

    CourseDto courseTwo = CourseDto.builder()
        .id(2L)
        .name("Sistemas Distribuidos")
        .credits(3)
        .academicYear(9)
        .build();

    expectedCourseList = new ArrayList<>();
    expectedCourseList.add(expectedCourseOne);
    expectedCourseList.add(courseTwo);
  }

  @Test
  public void findAll() {
    when(dao.findAll()).thenReturn(expectedCourseList);

    String expected = new Gson().toJson(expectedCourseList);
    String actual = new Gson().toJson(service.findAll());

    assertEquals(expected, actual);
  }

  @Test
  public void findById() {
    when(dao.findById(anyLong())).thenReturn(expectedCourseOne);

    String expected = new Gson().toJson(expectedCourseOne);
    String actual = new Gson().toJson(service.findById(1L));

    assertEquals(expected, actual);
  }

  @Test
  public void findByAcademicYear() {
    List<CourseDto> expectedCourses = new ArrayList<>();
    expectedCourses.add(expectedCourseOne);

    when(dao.findByAcademicYear(anyInt())).thenReturn(expectedCourses);

    String expected = new Gson().toJson(expectedCourses);
    String actual = new Gson().toJson(service.findByAcademicYear(10));

    assertEquals(expected, actual);
  }

  @Test
  public void save() {
    when(dao.save(any())).thenReturn(1L);

    String expected = new Gson().toJson(expectedCourseOne.getId());
    String actual = new Gson().toJson(service.save(expectedCourseOne));

    assertEquals(expected, actual);
  }

  @Test
  public void update() {
    expectedCourseOne.setId(null);

    when(dao.findById(anyLong())).thenReturn(expectedCourseOne);
    service.update(1L, expectedCourseOne);
  }

  @Test void delete() {
    service.deleteById(1L);
  }
}
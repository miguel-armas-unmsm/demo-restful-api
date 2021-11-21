//package com.demo.bbq.order.dao.impl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//import com.demo.bbq.order.model.dto.OrderDto;
//import com.demo.bbq.order.repository.OrderRepository;
//import com.demo.bbq.order.util.Util;
//import com.demo.bbq.order.model.entity.Order;
//import com.google.gson.Gson;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//@RunWith(MockitoJUnitRunner.class)
//class OrderDaoTest {
//
//  @InjectMocks
//  private OrderDaoImpl dao;
//
//  @Mock
//  private OrderRepository repository;
//
//  private OrderDto expectedCourseOne;
//  private List<OrderDto> expectedCourseList;
//  private Order savedOrderOne;
//  private List<Order> savedOrderList;
//
//  @BeforeEach
//  public void setup() throws IOException {
//    MockitoAnnotations.openMocks(this);
//
//    savedOrderOne = Util.buildModelFromJson("data/model/entity/Course.json", Order.class);
//    savedOrderOne.setId(1L);
//
//    Order savedOrderTwo = Order.builder()
//        .id(2L)
//        .name("Sistemas Distribuidos")
//        .credits(3)
//        .academicYear(9)
//        .build();
//
//    savedOrderList = new ArrayList<>();
//    savedOrderList.add(savedOrderOne);
//    savedOrderList.add(savedOrderTwo);
//
//    expectedCourseOne = Util.buildModelFromJson("data/model/dto/CourseDto.json", OrderDto.class);
//    expectedCourseOne.setId(1L);
//
//    OrderDto expectedCourseTwo = OrderDto.builder()
//        .id(2L)
//        .name("Sistemas Distribuidos")
//        .credits(3)
//        .academicYear(9)
//        .build();
//
//    expectedCourseList = new ArrayList<>();
//    expectedCourseList.add(expectedCourseOne);
//    expectedCourseList.add(expectedCourseTwo);
//  }
//
//  @Test
//  public void findAll() {
//    when(repository.findAll()).thenReturn(savedOrderList);
//
//    String expected = new Gson().toJson(expectedCourseList);
//    String actual = new Gson().toJson(dao.findAll());
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void findById() {
//    when(repository.findById(anyLong())).thenReturn(Optional.of(savedOrderOne));
//
//    String expected = new Gson().toJson(expectedCourseOne);
//    String actual = new Gson().toJson(dao.findById(1L));
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void findByAcademicYear() {
//    List<Order> savedCours = new ArrayList<>();
//    savedCours.add(savedOrderOne);
//
//    List<OrderDto> expectedCourses = new ArrayList<>();
//    expectedCourses.add(expectedCourseOne);
//
//    when(repository.findByAcademicYear(anyInt())).thenReturn(savedCours);
//
//    String expected = new Gson().toJson(expectedCourses);
//    String actual = new Gson().toJson(dao.findByAcademicYear(10));
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void save() {
//    when(repository.save(any())).thenReturn(savedOrderOne);
//
//    String expected = new Gson().toJson(expectedCourseOne.getId());
//    String actual = new Gson().toJson(dao.save(expectedCourseOne));
//
//    assertEquals(expected, actual);
//  }
//
//  @Test void delete() {
//    dao.deleteById(1L);
//  }
//
//}
//package com.demo.bbq.menuoption.business.impl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import com.demo.bbq.menuoption.service.MenuOptionService;
//import com.demo.bbq.menuoption.service.impl.MenuOptionServiceImpl;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import java.io.IOException;
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//class InvoiceServiceTest {
//
//  @InjectMocks
//  private MenuOptionServiceImpl service;
//
//  @Mock
//  private MenuOptionService dao;
//
//  private OrderDto expectedCourseOne;
//  private List<OrderDto> expectedCourseList;
//
//  @BeforeEach
//  public void setup() throws IOException {
//
//  }
//
//  @Test
//  public void findAll() {
//    when(dao.findByCategory()).thenReturn(expectedCourseList);
//
//    String expected = new Gson().toJson(expectedCourseList);
//    String actual = new Gson().toJson(service.findByCategory());
//
//    assertEquals(expected, actual);
//  }
//
//
//}
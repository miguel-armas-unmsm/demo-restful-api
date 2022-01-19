package com.demo.bbq.order.business.impl;

import static com.demo.bbq.order.util.Util.buildModelFromJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.demo.bbq.order.dao.OrderDao;
import com.demo.bbq.order.model.dto.OrderDto;
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

@RunWith(MockitoJUnitRunner.class)
class OrderServiceTest {

  @InjectMocks
  private OrderServiceImpl service;

  @Mock
  private OrderDao dao;

  private OrderDto expectedCourseOne;
  private List<OrderDto> expectedCourseList;

  @BeforeEach
  public void setup() throws IOException {

  }

  @Test
  public void findAll() {
    when(dao.findAll()).thenReturn(expectedCourseList);

    String expected = new Gson().toJson(expectedCourseList);
    String actual = new Gson().toJson(service.findAll());

    assertEquals(expected, actual);
  }


}
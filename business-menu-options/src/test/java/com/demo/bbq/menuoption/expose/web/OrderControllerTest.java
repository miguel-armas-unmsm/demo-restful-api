//package com.demo.bbq.order.expose.web;
//
//import static com.demo.bbq.order.util.Util.buildModelFromJson;
//import static java.nio.charset.StandardCharsets.UTF_8;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//
//import com.demo.bbq.order.business.OrderService;
//import com.demo.bbq.order.model.dto.OrderDto;
//import com.google.gson.Gson;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.BiFunction;
//import java.util.function.Function;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = OrderController.class)
//class OrderControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private OrderService service;
//
//  private OrderDto expectedCourseOne;
//  private List<OrderDto> expectedCourseList;
//
//  String uri;
//
//  @BeforeEach
//  public void setup() throws IOException {
//    expectedCourseOne = buildModelFromJson("data/model/dto/CourseDto.json", OrderDto.class);
//    expectedCourseOne.setId(1L);
//
//    OrderDto courseTwo = OrderDto.builder()
//        .id(2L)
//        .name("Sistemas Distribuidos")
//        .credits(3)
//        .academicYear(9)
//        .build();
//
//    expectedCourseList = new ArrayList<>();
//    expectedCourseList.add(expectedCourseOne);
//    expectedCourseList.add(courseTwo);
//
//    uri = "/demo/business/v1/courses";
//
//  }
//
//  @Test
//  public void findById() throws Exception {
//    when(service.findById(anyLong())).thenReturn(expectedCourseOne);
//
//    String expected = new Gson().toJson(expectedCourseOne);
//
//    MockHttpServletResponse response = this.sendRequest(buildRequestForGet.apply("/1"));
//    String actual = response.getContentAsString(UTF_8);
//
//    assertEquals(expected, actual);
//    assertEquals(HttpStatus.OK.value(), response.getStatus());
//  }
//
//  @Test
//  public void findAll() throws Exception {
//    when(service.findAll()).thenReturn(expectedCourseList);
//
//    String expected = new Gson().toJson(expectedCourseList);
//
//    MockHttpServletResponse response = this.sendRequest(buildRequestForGet.apply(StringUtils.EMPTY));
//    String actual = response.getContentAsString(UTF_8);
//
//    assertEquals(expected, actual);
//    assertEquals(HttpStatus.OK.value(), response.getStatus());
//  }
//
//  @Test
//  public void findByAcademicYear() throws Exception {
//    List<OrderDto> courses = new ArrayList<>();
//    courses.add(expectedCourseOne);
//
//    when(service.findByAcademicYear(anyInt())).thenReturn(courses);
//
//    String expected = new Gson().toJson(courses);
//
//    MockHttpServletResponse response = this.sendRequest(buildRequestForGet.apply("?academicYear=10"));
//    String actual = response.getContentAsString(UTF_8);
//
//    assertEquals(expected, actual);
//    assertEquals(HttpStatus.OK.value(), response.getStatus());
//  }
//
//  @Test
//  public void save() throws Exception {
//    OrderDto expectedCourse = buildModelFromJson("data/model/dto/CourseDto.json", OrderDto.class);
//    String requestBody = new Gson().toJson(expectedCourse);
//
//    when(service.save(any())).thenReturn(3L);
//
//    MockHttpServletResponse response = this.sendRequest(buildRequestForPost.apply(StringUtils.EMPTY, requestBody));
//
//    assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//  }
//
//  @Test
//  public void update() throws Exception {
//    OrderDto expectedCourse = buildModelFromJson("data/model/dto/CourseDto.json", OrderDto.class);
//    String requestBody = new Gson().toJson(expectedCourse);
//
//    MockHttpServletResponse response = this.sendRequest(buildRequestForPut.apply("/1", requestBody));
//
//    assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//  }
//
//  @Test
//  public void delete() throws Exception {
//    MockHttpServletResponse response = this.sendRequest(buildRequestForDelete.apply("/1"));
//
//    assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
//  }
//
//
//  private MockHttpServletResponse sendRequest(RequestBuilder requestBuilder) throws Exception {
//    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//    return result.getResponse();
//  }
//
//  private final Function<String, RequestBuilder> buildRequestForGet = resource ->
//      MockMvcRequestBuilders
//        .get(uri.concat(resource))
//        .accept(APPLICATION_JSON);
//
//  private final BiFunction<String, String, RequestBuilder> buildRequestForPost = (resource, requestBody) ->
//      MockMvcRequestBuilders
//          .post(uri.concat(resource))
//          .accept(APPLICATION_JSON)
//          .content(requestBody)
//          .contentType(APPLICATION_JSON);
//
//  private final BiFunction<String, String, RequestBuilder> buildRequestForPut = (resource, requestBody) ->
//      MockMvcRequestBuilders
//          .put(uri.concat(resource))
//          .accept(APPLICATION_JSON)
//          .content(requestBody)
//          .contentType(APPLICATION_JSON);
//
//  private final Function<String, RequestBuilder> buildRequestForDelete = resource ->
//      MockMvcRequestBuilders
//          .delete(uri.concat(resource));
//}
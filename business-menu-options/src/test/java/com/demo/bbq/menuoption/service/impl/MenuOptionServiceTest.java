//package com.demo.bbq.menuoption.service.impl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//import com.demo.bbq.menuoption.repository.MenuOptionRepository;
//import com.demo.bbq.menuoption.util.JsonFileReader;
//import com.demo.bbq.menuoption.util.mapper.MenuOptionMapper;
//import com.demo.bbq.menuoption.util.model.entity.MenuOption;
//import com.google.gson.Gson;
//import java.io.IOException;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@RunWith(MockitoJUnitRunner.class)
//class MenuOptionServiceTest {
//
//  @Configuration
//  @ComponentScan(basePackageClasses = MenuOptionMapper.class)
//  public static class MenuOptionMapperConfig { }
//
//  @InjectMocks
//  private MenuOptionServiceImpl menuOptionService;
//
//  @Mock
//  private MenuOptionRepository menuOptionRepository;
//
//  @MockBean
//  private MenuOptionMapper menuOptionMapper;
//
//  private List<MenuOption> expectedSavedMenuOptionList;
//
//  @BeforeEach
//  public void setup() throws IOException {
//    MockitoAnnotations.openMocks(this);
//
//    expectedSavedMenuOptionList = JsonFileReader
//        .getList("data/model/entity/menuoption/MenuOption_list.json", MenuOption[].class);
//
//  }
//
//  @Test
//  public void findAll() {
//    when(menuOptionRepository.findAll()).thenReturn(expectedSavedMenuOptionList);
//
//    String expected = new Gson().toJson(expectedSavedMenuOptionList);
//    String actual = new Gson().toJson(menuOptionService.findByCategory(null));
//    assertEquals(expected, actual);
//  }

//  @Test
//  public void findById() {
//    when(menuOptionMapper.findById(anyLong())).thenReturn(Optional.of(savedOrderOne));
//
//    String expected = new Gson().toJson(expectedCourseOne);
//    String actual = new Gson().toJson(menuOptionService.findById(1L));
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
//    when(menuOptionMapper.findByAcademicYear(anyInt())).thenReturn(savedCours);
//
//    String expected = new Gson().toJson(expectedCourses);
//    String actual = new Gson().toJson(menuOptionService.findByAcademicYear(10));
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void save() {
//    when(menuOptionMapper.save(any())).thenReturn(savedOrderOne);
//
//    String expected = new Gson().toJson(expectedCourseOne.getId());
//    String actual = new Gson().toJson(menuOptionService.save(expectedCourseOne));
//
//    assertEquals(expected, actual);
//  }
//
//  @Test void delete() {
//    menuOptionService.deleteById(1L);
//  }
//
//}
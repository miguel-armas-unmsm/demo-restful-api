//package com.demo.bbq.order.repository;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import com.demo.bbq.order.util.Util;
//import com.demo.bbq.order.model.entity.Order;
//import com.google.gson.Gson;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
///**
// * Para utilizar la fuente de datos propia de la aplicación en las pruebas unitaras:
// * '@AutoConfigureTestDatabase(replace = NONE)'
// */
//@DataJpaTest
//class OrderRepositoryTest {
//
//  @Autowired
//  private OrderRepository repository;
//
//  private Order expectedOrderSavedOne;
//  private List<Order> expectedListSavedCours;
//
//  @BeforeEach
//  void setup() throws IOException {
//
//    expectedOrderSavedOne = Util.buildModelFromJson("data/model/entity/Course.json", Order.class);
//    expectedOrderSavedOne.setId(1L);
//
//    Order expectedOrderSavedTwo = Order.builder()
//        .id(2L)
//        .name("Sistemas Distribuidos")
//        .credits(3)
//        .academicYear(9)
//        .build();
//
//    expectedListSavedCours = new ArrayList<>();
//    expectedListSavedCours.add(expectedOrderSavedOne);
//    expectedListSavedCours.add(expectedOrderSavedTwo);
//  }
//
//  @Test
//  public void findAll() {
//
//    String expected = new Gson().toJson(expectedListSavedCours);
//    String actual = new Gson().toJson(repository.findAll());
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void findById() {
//
//    String expected = new Gson().toJson(expectedOrderSavedOne);
//    String actual = new Gson().toJson(repository.findById(1L).get());
//
//    assertEquals(expected, actual);
//  }
//
//  @Test
//  public void findByAcademicYear() {
//
//    List<Order> expectedCours = new ArrayList<>();
//    expectedCours.add(expectedOrderSavedOne);
//
//    String expected = new Gson().toJson(expectedCours);
//    String actual = new Gson().toJson(repository.findByAcademicYear(10));
//
//    assertEquals(expected, actual);
//  }
//
//  /**
//   * Para no revertir los cambios: @Rollback(value = false)
//   */
//  @Test
//  public void save() throws IOException {
//
//    int itemsBefore = repository.findAll().size();
//
//    Order expectedOrder = Util.buildModelFromJson("data/model/entity/Course.json", Order.class);
//    Order actualOrder = repository.save(expectedOrder);
//    expectedOrder.setId(actualOrder.getId());
//
//    int itemsAfter = repository.findAll().size();
//
//    String expected = new Gson().toJson(expectedOrder);
//    String actual = new Gson().toJson(actualOrder);
//
//    assertEquals(itemsBefore + 1, itemsAfter);
//    assertEquals(expected, actual);
//    assertNotNull(actualOrder);
//    assertNotNull(actualOrder.getId());
//  }
//
//  @Test
//  public void deleteById() {
//    Long id = 1L;
//
//    boolean isExistBefore = repository.findById(id).isPresent();
//    repository.deleteById(1L);
//    boolean isExistAfter = repository.findById(id).isPresent();
//
//    assertTrue(isExistBefore);
//    assertFalse(isExistAfter);
//  }
//
//}
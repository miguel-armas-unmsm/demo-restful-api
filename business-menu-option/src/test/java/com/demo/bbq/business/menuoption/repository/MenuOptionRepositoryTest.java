package com.demo.bbq.business.menuoption.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import com.demo.bbq.business.menuoption.util.JsonFileReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


// @AutoConfigureTestDatabase(replace = NONE) //use real database
@DataJpaTest
@ActiveProfiles("test") //use application-test.yaml
class MenuOptionRepositoryTest {

  @Autowired
  private MenuOptionRepository repository;

  private List<MenuOption> expectedSavedMenuOptionList;

  @BeforeEach
  void setup() throws IOException {
    expectedSavedMenuOptionList = JsonFileReader
        .getList("data/model/entity/menuoption/MenuOption_list.json", MenuOption[].class);
  }

  @Test
  public void findAll() {
    String expected = new Gson().toJson(expectedSavedMenuOptionList);
    String actual = new Gson().toJson(repository.findAll());
    assertEquals(expected, actual);
  }

  @Test
  public void findById() {
    MenuOption expectedSavedMenuOptionThree = expectedSavedMenuOptionList.get(2);
    String expected = new Gson().toJson(expectedSavedMenuOptionThree);
    String actual = new Gson().toJson(repository.findById(3L).get());
    assertEquals(expected, actual);
  }

  @Test
  public void findByCategory() throws IOException {
    List<MenuOption> expectedFilteredMenuOptionList = expectedSavedMenuOptionList
        .stream()
        .filter(menuOption -> menuOption.getCategory().equals("food"))
        .collect(Collectors.toList());

    String expected = new Gson().toJson(expectedFilteredMenuOptionList);
    String actual = new Gson().toJson(repository.findByCategory("food"));
    assertEquals(expected, actual);
  }

//  @Rollback(value = false) // no revertir los cambios en BD tras la ejecución del test
  @Test
  public void save() throws IOException {
    int rowsNumberBefore = repository.findAll().size();
    MenuOption expectedMenuOption = JsonFileReader.getAnElement("data/model/entity/menuoption/MenuOption_element.json", MenuOption.class);
    repository.save(expectedMenuOption);
    int rowsNumberAfter = repository.findAll().size();
    MenuOption actualMenuOption = repository.findById(7L).get();

    String expected = new Gson().toJson(expectedMenuOption);
    String actual = new Gson().toJson(actualMenuOption);

    assertEquals(rowsNumberBefore + 1, rowsNumberAfter);
    assertEquals(expected, actual);
    assertNotNull(actualMenuOption);
    assertNotNull(actualMenuOption.getId());
  }

  @Test
  public void deleteById() {
    int rowsNumberBefore = repository.findAll().size();
    Long id = 1L;
    boolean isExistBefore = repository.findById(id).isPresent();
    repository.deleteById(1L);
    int rowsNumberAfter = repository.findAll().size();
    boolean isExistAfter = repository.findById(id).isPresent();

    assertEquals(rowsNumberBefore, rowsNumberAfter + 1);
    assertTrue(isExistBefore);
    assertFalse(isExistAfter);
  }

}
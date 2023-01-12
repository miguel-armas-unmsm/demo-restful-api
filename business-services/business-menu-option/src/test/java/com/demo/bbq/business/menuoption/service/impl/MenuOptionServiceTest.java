package com.demo.bbq.business.menuoption.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.demo.bbq.business.menuoption.repository.MenuOptionRepository;
import com.demo.bbq.business.menuoption.util.JsonFileReader;
import com.demo.bbq.business.menuoption.util.mapper.MenuOptionMapper;
import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MenuOptionServiceTest {

  @InjectMocks
  private MenuOptionServiceImpl menuOptionService;

  @Mock
  private MenuOptionRepository menuOptionRepository;

  @Spy
  private MenuOptionMapper menuOptionMapper = Mappers.getMapper(MenuOptionMapper.class);

  private List<MenuOption> expectedSavedMenuOptionList;

  private MenuOption expectedSavedMenuOption;

  private List<MenuOptionResponse> expectedSavedMenuOptionResponseList;

  private MenuOptionResponse expectedSavedMenuOptionResponse;

  private MenuOptionRequest menuOptionRequest;

  @Before
  public void setup() throws IOException {
    expectedSavedMenuOptionList = JsonFileReader
        .getList("data/model/menuoption/entity/MenuOption_list.json", MenuOption[].class);

    expectedSavedMenuOption = JsonFileReader.getAnElement(
            "data/model/menuoption/entity/MenuOption.json", MenuOption.class);

    expectedSavedMenuOptionResponseList = JsonFileReader
            .getList("data/model/menuoption/dto/response/MenuOptionResponse_list.json", MenuOptionResponse[].class);

    expectedSavedMenuOptionResponse = JsonFileReader.getAnElement(
            "data/model/menuoption/dto/response/MenuOptionResponse.json", MenuOptionResponse.class);

    menuOptionRequest = JsonFileReader.getAnElement(
            "data/model/menuoption/dto/request/MenuOptionRequest.json", MenuOptionRequest.class);
  }

  @Test
  public void findAll() {
    when(menuOptionRepository.findAll()).thenReturn(expectedSavedMenuOptionList);

    String expected = new Gson().toJson(expectedSavedMenuOptionResponseList);
    String actual = new Gson().toJson(menuOptionService.findByCategory(null));
    assertEquals(expected, actual);
  }

  @Test
  public void findById() {
    when(menuOptionRepository.findById(anyLong())).thenReturn(Optional.of(expectedSavedMenuOption));

    String expected = new Gson().toJson(expectedSavedMenuOptionResponse);
    String actual = new Gson().toJson(menuOptionService.findById(7L));

    assertEquals(expected, actual);
  }

  @Test
  public void findByCategory() {
    when(menuOptionRepository.findByCategory("main-dish")).thenReturn(expectedSavedMenuOptionList
            .stream()
            .filter(menuOption -> menuOption.getCategory().equals("main-dish"))
            .collect(Collectors.toList()));

    String expected = new Gson().toJson(expectedSavedMenuOptionResponseList
            .stream()
            .filter(menuOption -> menuOption.getCategory().equals("main-dish"))
            .collect(Collectors.toList()));
    String actual = new Gson().toJson(menuOptionService.findByCategory("main-dish"));
    assertEquals(expected, actual);
  }

  @Test
  public void save() {
    when(menuOptionRepository.save(any())).thenReturn(expectedSavedMenuOption);

    String expected = new Gson().toJson(expectedSavedMenuOptionResponse.getId());
    String actual = new Gson().toJson(menuOptionService.save(menuOptionRequest));

    assertEquals(expected, actual);
  }

  @Test
  public void delete() {
    when(menuOptionRepository.findById(anyLong())).thenReturn(Optional.of(expectedSavedMenuOption));
    menuOptionService.deleteById(7L);
  }

}
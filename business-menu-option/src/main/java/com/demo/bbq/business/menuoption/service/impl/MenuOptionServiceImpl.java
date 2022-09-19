package com.demo.bbq.business.menuoption.service.impl;

import com.demo.bbq.business.menuoption.service.MenuOptionService;
import com.demo.bbq.business.menuoption.repository.MenuOptionRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.demo.bbq.business.menuoption.util.catalog.MenuOptionCategory;
import com.demo.bbq.business.menuoption.util.exception.ExceptionCatalog;
import com.demo.bbq.business.menuoption.util.mapper.MenuOptionMapper;
import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import com.demo.bbq.support.logstash.Markers;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del
 * contexto Menu Option.<br/>
 *
 * <b>Class</b>: MenuOptionServiceImpl<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class MenuOptionServiceImpl implements MenuOptionService {

  private final MenuOptionRepository menuOptionRepository;
  private final MenuOptionMapper menuOptionMapper;

  @Override
  public List<MenuOptionResponse> findByCategory(String categoryCode) {
    return (Optional.ofNullable(categoryCode).isEmpty()
          ? menuOptionRepository.findAll()
          : validateCategory(categoryCode))
        .stream()
        .map(menuOptionMapper::fromEntityToResponse)
        .peek(menuOption -> log.info(Markers.SENSITIVE_JSON, "findByCategory: {}", new Gson().toJson(menuOption)))
        .collect(Collectors.toList());
  }

  private List<MenuOption> validateCategory(String categoryCode) {
    MenuOptionCategory.validateCategory.accept(categoryCode);
    return menuOptionRepository.findByCategory(categoryCode);
  }

  @Override
  public MenuOptionResponse findById(Long id) {
    return menuOptionRepository.findById(id)
        .map(menuOptionMapper::fromEntityToResponse)
        .orElseThrow(ExceptionCatalog.ERROR1000::buildException);
  }

  @Override
  public Long save(MenuOptionRequest menuOption) {
    return menuOptionRepository.save(menuOptionMapper.fromRequestToEntity(menuOption)).getId();
  }

  @Override
  public Long update(Long id, MenuOptionRequest menuOption) {
    return Optional.of(this.findById(id))
      .map(menuOptionFound -> {
        MenuOption menuOptionEntity = menuOptionMapper.fromRequestToEntity(menuOption);
        menuOptionEntity.setId(id);
        menuOptionRepository.save(menuOptionEntity);
        return menuOptionEntity.getId();
      })
      .orElse(null);
  }

  @Override
  public Long deleteById(Long id) {
    return Optional.of(this.findById(id))
        .map(menuOptionFound -> {
          menuOptionRepository.deleteById(id);
          return menuOptionFound.getId();
        })
        .orElse(null);
  }

}

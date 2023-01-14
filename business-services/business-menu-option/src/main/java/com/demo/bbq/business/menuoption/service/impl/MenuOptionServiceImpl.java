package com.demo.bbq.business.menuoption.service.impl;

import com.demo.bbq.business.menuoption.service.MenuOptionService;
import com.demo.bbq.business.menuoption.repository.MenuOptionRepository;
import com.demo.bbq.business.menuoption.util.catalog.MenuOptionCategory;
import com.demo.bbq.business.menuoption.util.exception.ExceptionCatalog;
import com.demo.bbq.business.menuoption.util.mapper.MenuOptionMapper;
import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import com.demo.bbq.support.logstash.Markers;
import com.google.gson.Gson;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del contexto Menu
 * Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
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
          : this.validateMenuOptionAndFindByCategory(categoryCode))
        .stream()
        .map(menuOptionMapper::fromEntityToResponse)
        .peek(menuOption -> log.info(Markers.SENSITIVE_JSON, "findByCategory: {}", new Gson().toJson(menuOption)))
        .collect(Collectors.toList());
  }

  private List<MenuOption> validateMenuOptionAndFindByCategory(String categoryCode) {
    MenuOptionCategory.validateCategory.accept(categoryCode);
    return menuOptionRepository.findByCategory(categoryCode);
  }

  @Override
  public MenuOptionResponse findById(Long id) {
    return menuOptionRepository.findById(id)
        .map(menuOptionMapper::fromEntityToResponse)
        .orElseThrow(ExceptionCatalog.ERROR1000::buildCustomException);
  }

  @Override
  public Long save(MenuOptionRequest menuOption) {
    return menuOptionRepository.save(menuOptionMapper.fromRequestToEntity(menuOption)).getId();
  }

  @Override
  public Long update(Long id, MenuOptionRequest menuOption) {
    return menuOptionRepository.findById(id)
      .map(menuOptionFound -> {
        MenuOption menuOptionEntity = menuOptionMapper.fromRequestToEntity(menuOption);
        menuOptionEntity.setId(id);
        menuOptionRepository.save(menuOptionEntity);
        return menuOptionEntity.getId();
      })
      .orElseThrow(ExceptionCatalog.ERROR1000::buildCustomException);
  }

  @Override
  public Long deleteById(Long id) {
    return menuOptionRepository.findById(id)
        .map(menuOptionFound -> {
          menuOptionRepository.deleteById(id);
          return menuOptionFound.getId();
        })
        .orElseThrow(ExceptionCatalog.ERROR1000::buildCustomException);
  }

}

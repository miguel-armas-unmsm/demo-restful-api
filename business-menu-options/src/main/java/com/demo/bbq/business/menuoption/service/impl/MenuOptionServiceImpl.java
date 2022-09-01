package com.demo.bbq.business.menuoption.service.impl;

import com.demo.bbq.business.menuoption.service.MenuOptionService;
import com.demo.bbq.business.menuoption.repository.MenuOptionRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
  public List<MenuOptionResponse> findByCategory(String name) {
    return (Optional.ofNullable(name).isEmpty()
          ? menuOptionRepository.findAll()
          : menuOptionRepository.findByCategory(name))
        .stream()
        .map(menuOptionMapper::fromEntityToResponse)
        .peek(menuOption -> log.info(Markers.SENSITIVE_JSON, "findByCategory: {}", new Gson().toJson(menuOption)))
        .collect(Collectors.toList());
  }

  @Override
  public MenuOptionResponse findById(Long id) {
    return menuOptionRepository.findById(id)
        .map(menuOptionMapper::fromEntityToResponse)
        .orElseThrow(ExceptionCatalog.ERROR0001::buildException);
  }

  @Override
  public Long save(MenuOptionRequest menuOption) {
    return menuOptionRepository.save(menuOptionMapper.fromRequestToEntity(menuOption)).getId();
  }

  @Override
  public void update(Long id, MenuOptionRequest menuOption) {
    Optional.of(this.findById(id))
        .ifPresentOrElse(menuOptionFound -> {
          MenuOption menuOptionEntity = menuOptionMapper.fromRequestToEntity(menuOption);
          menuOptionEntity.setId(id);
          menuOptionRepository.save(menuOptionEntity);
        }, () -> {});
  }

  @Override
  public void deleteById(Long id) {
    Optional.of(this.findById(id))
        .ifPresentOrElse(menuOptionFound -> menuOptionRepository.deleteById(id), () -> {});
  }

}

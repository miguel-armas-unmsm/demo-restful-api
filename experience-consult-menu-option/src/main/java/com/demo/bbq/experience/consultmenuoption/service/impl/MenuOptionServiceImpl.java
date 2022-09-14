package com.demo.bbq.experience.consultmenuoption.service.impl;

import com.demo.bbq.experience.consultmenuoption.repository.proxy.MenuOptionProxy;
import com.demo.bbq.experience.consultmenuoption.service.MenuOptionService;
import com.demo.bbq.experience.consultmenuoption.util.mapper.MenuOptionMapper;
import com.demo.bbq.experience.consultmenuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.experience.consultmenuoption.util.model.dto.response.MenuOptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
@RequiredArgsConstructor
@Service
public class MenuOptionServiceImpl implements MenuOptionService {

  private final MenuOptionProxy menuOptionProxy;
  private final MenuOptionMapper menuOptionMapper;

  @Override
  public List<MenuOptionResponse> findByCategory(String name) {
    return menuOptionProxy.findByCategory(name)
        .blockingFirst()
        .stream()
        .map(menuOptionMapper::fromThirdToResponse)
        .collect(Collectors.toList());
  }

  @Override
  public MenuOptionResponse findById(Long id) {
    return menuOptionMapper.fromThirdToResponse(menuOptionProxy.findById(id)
        .blockingFirst());
  }

  @Override
  public void save(MenuOptionRequest menuOption) {
    menuOptionProxy.save(menuOption).subscribe();
  }

  @Override
  public void update(Long id, MenuOptionRequest menuOption) {
    menuOptionProxy.update(id, menuOption).subscribe();
  }

  @Override
  public void deleteById(Long id) {
    menuOptionProxy.delete(id).subscribe();
  }
}

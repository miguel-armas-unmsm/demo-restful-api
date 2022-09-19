package com.demo.bbq.business.menuoption.service;

import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import java.util.List;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del
 * contexto Menu Option.<br/>
 *
 * <b>Interface</b>: MenuOptionService<br/>
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
public interface MenuOptionService {

  List<MenuOptionResponse> findByCategory(String categoryCode);

  MenuOptionResponse findById(Long id);

  Long save (MenuOptionRequest menuOption);

  Long update(Long id, MenuOptionRequest menuOption);

  Long deleteById(Long id);
}

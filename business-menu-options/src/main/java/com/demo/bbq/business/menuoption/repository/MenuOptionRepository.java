package com.demo.bbq.business.menuoption.repository;

import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Menu Option.<br/>
 *
 * <b>Interface</b>: MenuOptionRepository<br/>
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
@Repository
public interface MenuOptionRepository extends CrudRepository<MenuOption, Long> {

  List<MenuOption> findAll();

  Optional<MenuOption> findById(Long id);

  List<MenuOption> findByCategory(String category);

  MenuOption save(MenuOption menuOption);

  void deleteById(Long id);
}
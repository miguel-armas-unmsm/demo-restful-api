package com.demo.bbq.business.menuoption.repository;

import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Menu Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Repository
public interface MenuOptionRepository extends CrudRepository<MenuOption, Long> {

  List<MenuOption> findAll();

  Optional<MenuOption> findById(Long id);

  List<MenuOption> findByCategory(String category);

  MenuOption save(MenuOption menuOption);

  void deleteById(Long id);
}
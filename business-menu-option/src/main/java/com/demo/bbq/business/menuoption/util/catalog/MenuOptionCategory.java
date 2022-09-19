package com.demo.bbq.business.menuoption.util.catalog;

import com.demo.bbq.business.menuoption.util.exception.ExceptionCatalog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * <br/>Clase Enum que define las categorías de opciones de menú permitidas en el contexto Menu Option.<br/>
 *
 * <b>Class</b>: MenuOptionCategory<br/>
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
@AllArgsConstructor
@Getter
public enum MenuOptionCategory {

  MAIN_DISH("01", "Plato principal"),
  DRINK("02", "Bebida"),
  DESSERT("03", "Postre");

  private final String code;
  private final String description;

  public static Consumer<String> validateCategory =
      menuOptionCategoryCode -> Arrays.stream(MenuOptionCategory.values())
          .filter(menuOptionCategory -> menuOptionCategory.getCode().equals(menuOptionCategoryCode))
          .findFirst()
          .orElseThrow(ExceptionCatalog.ERROR1001::buildException);

}

package com.demo.bbq.order.util.mapper;

import com.demo.bbq.order.model.dto.MenuItemDto;
import com.demo.bbq.order.model.entity.MenuItem;
import java.util.function.Function;

/**
 * <br/>Clase Mapper que mueve la información del contexto MenuItem entre objetos
 * de tipo Entity y Dto.<br/>
 *
 * <b>Class</b>: MenuItemMapper<br/>
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
public class MenuItemMapper {

  public static Function<MenuItem, MenuItemDto> buildDto = order -> MenuItemDto.builder()
      .number(order.getNumber())
      .name(order.getName())
      .categoryCode(order.getCategoryCode())
      .price(order.getPrice())
      .quantity(0)
      .build();

  public static Function<MenuItemDto, MenuItem> buildEntity = order -> MenuItem.builder()
      .number(order.getNumber())
      .name(order.getName())
      .categoryCode(order.getCategoryCode())
      .price(order.getPrice())
      .build();

}

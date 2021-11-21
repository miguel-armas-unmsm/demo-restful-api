package com.demo.bbq.order.util.mapper;

import com.demo.bbq.order.model.dto.OrderDto;
import com.demo.bbq.order.model.entity.Order;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <br/>Clase Mapper que mueve la información del contexto Order entre objetos
 * de tipo Entity y Dto.<br/>
 *
 * <b>Class</b>: OrderMapper<br/>
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
public class OrderMapper {

  public static Function<Order, OrderDto> buildDto = order -> OrderDto.builder()
      .id(order.getId())
      .number(order.getNumber())
      .statusCode(order.getStatusCode())
      .date(order.getDate())
      .menuItemList(order.getMenuItemList().stream()
          .map(MenuItemMapper.buildDto)
          .collect(Collectors.toList()))
      .build();

  public static Function<OrderDto, Order> buildEntity = order -> Order.builder()
      .id(order.getId())
      .number(order.getNumber())
      .statusCode(order.getStatusCode())
      .date(order.getDate())
      .build();

  public static BiFunction<OrderDto, OrderDto, OrderDto> buildUpdatedOrder = (orderFound, orderUpdate) -> {
    orderFound.setNumber(orderUpdate.getNumber());
    orderFound.setStatusCode(orderUpdate.getStatusCode());
    orderFound.setDate(orderUpdate.getDate());
    orderFound.setActive(orderUpdate.isActive());
    return orderFound;
  };

  public static Function<Long, URI> buildUriLocation = id -> ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();
}

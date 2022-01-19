package com.demo.bbq.order.dao.impl;

import static com.demo.bbq.order.util.exception.ExceptionCatalog.ERROR0001;

import com.demo.bbq.order.dao.OrderDao;
import com.demo.bbq.order.model.dto.MenuItemDto;
import com.demo.bbq.order.model.dto.OrderDto;
import com.demo.bbq.order.model.entity.OrderDetail;
import com.demo.bbq.order.repository.OrderDetailRepository;
import com.demo.bbq.order.repository.OrderRepository;
import com.demo.bbq.order.util.mapper.MenuItemMapper;
import com.demo.bbq.order.util.mapper.OrderMapper;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase DAO que implementa los métodos necesarios para separar los objetos de acceso a datos
 * de los objetos de negocio del contexto Order.<br/>
 *
 * <b>Class</b>: OrderDaoImpl<br/>
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
@Component
public class OrderDaoImpl implements OrderDao {

  private final OrderRepository orderRepository;
  private final OrderDetailRepository orderDetailRepository;
  private final OrderMapper orderMapper;
  private final MenuItemMapper menuItemMapper;

  @Override
  public List<OrderDto> findAll() {

    return orderRepository.findAll().stream()
        .map(orderMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public OrderDto findById(Long id) {
    return buildOrder.apply(id).get();
  }

  @Override
  public Long save(OrderDto orderDto) {
    return orderMapper.toDto((orderRepository.save(orderMapper.toEntity(orderDto)))).getId();
  }

  @Override
  public void deleteById(Long id) {
    orderRepository.deleteById(id);
  }

  private final Function<Long, Optional<OrderDto>> buildOrder = orderId ->
      orderDetailRepository.findByOrderId(orderId)
      .stream()
      .map(orderDetail -> orderRepository.findById(orderDetail.getId().getOrderId())
          .map(order -> orderMapper.toDtoAll(order, orderDetail)))
          .filter(Optional::isPresent)
          .map(Optional::get)
          .findFirst();

  private final Function<Long, List<MenuItemDto>> buildMenuItemList = orderId ->
      orderDetailRepository.findByOrderId(orderId)
      .stream()
      .map()


}

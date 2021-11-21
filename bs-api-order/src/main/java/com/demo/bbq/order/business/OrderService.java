package com.demo.bbq.order.business;

import com.demo.bbq.order.model.dto.OrderDto;

import java.util.List;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio
 * del contexto Order.<br/>
 *
 * <b>Interface</b>: OrderService<br/>
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
public interface OrderService {

  List<OrderDto> findAll();

  OrderDto findById(Long id);

  Long save(OrderDto course);

  void deleteById(Long id);

  void update(Long id, OrderDto course);
}

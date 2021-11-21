package com.demo.bbq.order.dao;

import com.demo.bbq.order.model.dto.OrderDto;
import java.util.List;

/**
 * <br/>Interface DAO que define los métodos necesarios para separar los objetos de acceso a datos
 * de los objetos de negocio del contexto Order.<br/>
 *
 * <b>Class</b>: OrderDao<br/>
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
public interface OrderDao {

  List<OrderDto> findAll();

  OrderDto findById(Long id);

  Long save (OrderDto orderDto);

  void deleteById(Long id);
}

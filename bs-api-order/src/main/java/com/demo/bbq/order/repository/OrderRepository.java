package com.demo.bbq.order.repository;

import com.demo.bbq.order.model.entity.Order;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Order.<br/>
 *
 * <b>Interface</b>: OrderRepository<br/>
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
public interface OrderRepository extends CrudRepository<Order, Long> {

  List<Order> findAll();

  Optional<Order> findById(Long id);

  Order save(Order order);

  void deleteById(Long id);
}
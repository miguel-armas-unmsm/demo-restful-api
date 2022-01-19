package com.demo.bbq.order.business.impl;

import com.demo.bbq.order.dao.OrderDao;
import com.demo.bbq.order.business.OrderService;
import com.demo.bbq.order.model.dto.OrderDto;
import java.util.List;
import java.util.Optional;

import com.demo.bbq.order.util.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Order.<br/>
 *
 * <b>Class</b>: OrderServiceImpl<br/>
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
@Service
public class OrderServiceImpl implements OrderService {

  private final OrderDao dao;
  private final OrderMapper mapper;

  @Override
  public List<OrderDto> findAll() {
    return dao.findAll();
  }

  @Override
  public OrderDto findById(Long id) {
    return dao.findById(id);
  }

  @Override
  public Long save(OrderDto course) {
    return dao.save(course);
  }

  @Override
  public void update(Long id, OrderDto course) {
    course.setId(id);
    Optional.of(dao.findById(id))
        .ifPresent(courseFound -> {
          course.setId(id);
          dao.save(course);
        });
  }

  @Override
  public void deleteById(Long id) {
    Optional.of(dao.findById(id))
        .ifPresent(course -> dao.deleteById(id));
  }

}

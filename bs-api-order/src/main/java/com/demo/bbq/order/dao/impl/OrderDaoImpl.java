package com.demo.bbq.order.dao.impl;

import static com.demo.bbq.order.util.exception.ExceptionCatalog.ERROR0001;

import com.demo.bbq.order.dao.OrderDao;
import com.demo.bbq.order.model.dto.OrderDto;
import com.demo.bbq.order.repository.OrderRepository;
import com.demo.bbq.order.util.mapper.OrderMapper;

import java.util.List;
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

  private final OrderRepository repository;

  @Override
  public List<OrderDto> findAll() {
    return repository.findAll().stream()
        .map(OrderMapper.buildDto)
        .collect(Collectors.toList());
  }

  @Override
  public OrderDto findById(Long id) {
    return repository.findById(id)
        .map(OrderMapper.buildDto)
        .orElseThrow(ERROR0001::buildException);
  }

  @Override
  public Long save(OrderDto orderDto) {
    return OrderMapper.buildDto.apply(repository.save(OrderMapper.buildEntity.apply(orderDto))).getId();
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}

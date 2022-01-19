package com.demo.bbq.order.repository;

import com.demo.bbq.order.model.dto.MenuItemDto;
import com.demo.bbq.order.model.entity.MenuItem;
import com.demo.bbq.order.model.entity.Order;
import com.demo.bbq.order.model.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

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
@RequiredArgsConstructor
@Repository
public class QueriesOrderRepository {

  private final EntityManager entityManager;

  public List<String> findStatusCode(Long orderId) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();

    CriteriaQuery<String> query = builder.createQuery(String.class);
    Root<Order> root = query.from(Order.class);

    query.select(root.get("statusCode"));
    List<String> statusCodeList = entityManager.createQuery(query).getResultList();

    entityManager.close();
    return statusCodeList;
  }

  public List<String> findMenuItemByOrderId(Long orderId) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();

    return null;
  }
}

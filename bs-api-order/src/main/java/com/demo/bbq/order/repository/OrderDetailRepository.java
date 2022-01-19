package com.demo.bbq.order.repository;

import com.demo.bbq.order.model.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {

  List<OrderDetail> findByOrderId(Long orderId);
}

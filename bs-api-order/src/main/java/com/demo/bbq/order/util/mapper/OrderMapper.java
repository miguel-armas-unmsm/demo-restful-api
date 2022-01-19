package com.demo.bbq.order.util.mapper;

import com.demo.bbq.order.model.dto.OrderDto;
import com.demo.bbq.order.model.entity.Order;
import com.demo.bbq.order.model.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  OrderDto toDto(Order order);

  @Mapping(target = "orderDetail.quantity", source = )
  OrderDto toDtoAll(Order order, OrderDetail orderDetail);

  Order toEntity(OrderDto order);

}

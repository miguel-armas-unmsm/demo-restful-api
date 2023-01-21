package com.demo.bbq.business.payment.util.mapper;

import com.demo.bbq.business.payment.util.model.dto.request.MenuOrderRequest;
import com.demo.bbq.business.payment.util.model.entity.MenuOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuOrderMapper {

//  List<MenuOrderResponse> fromEntityListToRequestList(List<MenuOrder> menuOrderCollection);

  MenuOrder fromRequestToEntity(MenuOrderRequest menuOrderRequest, Long tableId);
}

package com.demo.bbq.business.diningroomorder.util.mapper;

import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.entity.MenuOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuOrderMapper {

//  List<MenuOrderResponse> fromEntityListToRequestList(List<MenuOrder> menuOrderCollection);

  MenuOrder fromRequestToEntity(MenuOrderRequest menuOrderRequest, Long tableId);
}

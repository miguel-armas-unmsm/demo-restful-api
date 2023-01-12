package com.demo.bbq.business.diningroomorder.util.mapper;

import com.demo.bbq.business.diningroomorder.util.model.dto.response.MenuOrderResponse;
import com.demo.bbq.business.diningroomorder.util.model.entity.MenuOrder;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuOrderMapper {

  List<MenuOrderResponse> fromEntityListToRequestList(List<MenuOrder> menuOrderCollection);
}

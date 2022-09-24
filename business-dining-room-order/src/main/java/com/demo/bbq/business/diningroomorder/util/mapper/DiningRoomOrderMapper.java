package com.demo.bbq.business.diningroomorder.util.mapper;

import com.demo.bbq.business.diningroomorder.util.model.dto.request.DiningRoomOrderRequest;
import com.demo.bbq.business.diningroomorder.util.model.entity.DiningRoomOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiningRoomOrderMapper {

  DiningRoomOrder fromRequestToEntity(DiningRoomOrderRequest diningRoomOrder, Boolean isActive);
}

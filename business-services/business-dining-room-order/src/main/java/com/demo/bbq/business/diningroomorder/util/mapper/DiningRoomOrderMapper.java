package com.demo.bbq.business.diningroomorder.util.mapper;

import com.demo.bbq.business.diningroomorder.util.model.dto.response.DiningRoomOrderResponse;
import com.demo.bbq.business.diningroomorder.util.model.entity.DiningRoomTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiningRoomOrderMapper {

  DiningRoomOrderResponse fromEntityToResponse(DiningRoomTable diningRoomOrder);
}

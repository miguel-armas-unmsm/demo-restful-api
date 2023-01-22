package com.demo.bbq.business.payment.util.mapper;

import com.demo.bbq.business.payment.util.model.dto.response.DiningRoomOrderResponse;
import com.demo.bbq.business.payment.util.model.entity.DiningRoomTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiningRoomOrderMapper {

  DiningRoomOrderResponse fromEntityToResponse(DiningRoomTable diningRoomOrder);
}

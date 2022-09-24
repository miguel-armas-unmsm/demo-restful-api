package com.demo.bbq.business.diningroomorder.util.mapper;

import com.demo.bbq.business.diningroomorder.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.diningroomorder.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.diningroomorder.util.model.dto.third.MenuOptionThird;
import com.demo.bbq.business.diningroomorder.util.model.entity.MenuOption;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MenuOptionMapper {

  MenuOptionResponse fromThirdToResponse(MenuOptionThird diningRoomOrder, Integer quantity);

  Collection<MenuOption> fromEntityListToRequestList(Collection<MenuOptionRequest> menuOptionCollection);
}

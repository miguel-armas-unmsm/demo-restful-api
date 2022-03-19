package com.demo.bbq.menupurchase.menuoption.util.mapper;

import com.demo.bbq.menupurchase.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.menupurchase.menuoption.util.model.dto.thirdparty.MenuOptionThird;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuOptionMapper {

  MenuOptionResponse fromThirdToResponse(MenuOptionThird menuOption);
}

package com.demo.bbq.business.menuoption.util.mapper;

import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuOptionMapper {

  MenuOptionResponse fromEntityToResponse(MenuOption menuOption);
  MenuOption fromRequestToEntity(MenuOptionRequest menuOption);
}

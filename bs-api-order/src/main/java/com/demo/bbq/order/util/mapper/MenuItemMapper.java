package com.demo.bbq.order.util.mapper;

import com.demo.bbq.order.model.dto.MenuItemDto;
import com.demo.bbq.order.model.entity.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

  @Mapping(target = "quantity", expression = "java(entity.getOrderDetailList().size())")
  MenuItemDto toDto(MenuItem entity);

//  default List<MenuItemDto> toDtoList(List<MenuItem> dtoList) {
//    return dtoList.stream().map(this::toDto).collect(Collectors.toList());
//  }
}

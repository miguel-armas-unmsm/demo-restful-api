package com.demo.bbq.business.menuoption.service.impl;

import com.demo.bbq.business.menuoption.service.MenuOptionService;
import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import java.util.Optional;
import java.util.function.Function;
import javax.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class MenuOptionServiceImpl implements MenuOptionService {

  @Override
  public Uni<MenuOptionResponse> findById(Long id) {
    return MenuOption.<MenuOption>findById(id)
        .map(fromEntityToResponse);
  }

  @Override
  public Multi<MenuOptionResponse> findByCategory(String categoryCode) {
    return (Optional.ofNullable(categoryCode).isEmpty()
        ? MenuOption.<MenuOption>findAll()
        : MenuOption.<MenuOption>find("category", categoryCode))
        .stream()
        .map(fromEntityToResponse);
  }

  @Override
  public Uni<Long> save(MenuOptionRequest menuOptionRequest) {
    return Panache.withTransaction(() -> fromRequestToEntity.apply(menuOptionRequest)
        .<MenuOption>persist())
        .invoke(x -> log.info("saved: " + x.toString()))
        .map(fromEntityToResponse)
        .map(MenuOptionResponse::getId);
  }

  @Override
  public Uni<Long> update(MenuOptionRequest menuOptionRequest, Long id) {
    return Panache.withTransaction(() -> MenuOption.<MenuOption>findById(id)
        .onItem()
        .ifNotNull()
        .invoke(menuOptionFound -> {
          menuOptionFound.setDescription(menuOptionRequest.getDescription());
          menuOptionFound.setCategory(menuOptionRequest.getCategory());
          menuOptionFound.setPrice(menuOptionRequest.getPrice());
          menuOptionFound.setActive(menuOptionRequest.isActive());
        }))
        .map(menuOption -> menuOption.id);
  }

  @Override
  public Uni<Boolean> deleteById(Long id) {
    return Panache.withTransaction(() -> MenuOption.deleteById(id));
  }

  private static final Function<MenuOption, MenuOptionResponse>
      fromEntityToResponse = menuOption -> MenuOptionResponse.builder()
      .id(menuOption.id)
      .description(menuOption.getDescription())
      .category(menuOption.getCategory())
      .price(menuOption.getPrice())
      .active(menuOption.isActive())
      .build();

  private static final Function<MenuOptionRequest, MenuOption>
      fromRequestToEntity = menuOptionRequest -> MenuOption.builder()
      .description(menuOptionRequest.getDescription())
      .category(menuOptionRequest.getCategory())
      .price(menuOptionRequest.getPrice())
      .active(menuOptionRequest.isActive())
      .build();

}

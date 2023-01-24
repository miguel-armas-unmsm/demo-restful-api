package com.demo.bbq.business.menuoption.service;

import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface MenuOptionService {

  Uni<MenuOptionResponse> findById(Long id);

  Multi<MenuOptionResponse> findByCategory(String categoryCode);

  Uni<Long> save(MenuOptionRequest menuOptionRequest);

  Uni<Long> update(MenuOptionRequest menuOptionRequest, Long id);

  Uni<Boolean> deleteById(Long id);
}

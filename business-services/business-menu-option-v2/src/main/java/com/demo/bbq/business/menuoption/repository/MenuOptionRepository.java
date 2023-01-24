package com.demo.bbq.business.menuoption.repository;

import com.demo.bbq.business.menuoption.util.model.entity.MenuOption;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MenuOptionRepository implements PanacheRepositoryBase<MenuOption, Long> {
}

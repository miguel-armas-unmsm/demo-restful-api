package com.demo.bbq.business.payment.repository.database;

import com.demo.bbq.business.payment.util.model.entity.MenuOrder;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar los datos del contexto  Menu Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Repository
public interface MenuOrderRepository extends CrudRepository<MenuOrder, Long> {

  MenuOrder save(MenuOrder menuOrder);

  Optional<MenuOrder> findByMenuOptionId(Long menuOptionId);
}

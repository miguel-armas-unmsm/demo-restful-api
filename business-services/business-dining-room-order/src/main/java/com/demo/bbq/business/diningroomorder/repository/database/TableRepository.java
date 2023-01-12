package com.demo.bbq.business.diningroomorder.repository.database;

import com.demo.bbq.business.diningroomorder.util.model.entity.DiningRoomTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar los datos del contexto  Dining Room
 * Table.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Repository
public interface TableRepository extends CrudRepository<DiningRoomTable, Long> {

  Optional<DiningRoomTable> findByTableNumber(Integer tableNumber);

}
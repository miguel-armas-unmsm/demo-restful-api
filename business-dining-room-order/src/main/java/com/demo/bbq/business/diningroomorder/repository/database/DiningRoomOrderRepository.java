package com.demo.bbq.business.diningroomorder.repository.database;

import com.demo.bbq.business.diningroomorder.util.model.entity.DiningRoomOrder;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar los datos del contexto  Dining Room
 * Order.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Repository
public interface DiningRoomOrderRepository extends ReactiveMongoRepository<DiningRoomOrder, String> {

  Flux<DiningRoomOrder> findByTableNumber(Integer tableNumber);

}
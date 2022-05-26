package com.demo.pay.accountholder.repository;

import java.util.Optional;
import com.fisi.unmsm.database.model.entity.Holder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Holder.<br/>
 *
 * <b>Interface</b>: HolderRepository<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@Repository
public interface AccountHolderRepository extends CrudRepository<Holder, Long> {

  Optional<Holder> findById(Long holderId);
}
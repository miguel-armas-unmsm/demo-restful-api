package com.demo.pay.servicebill.repository;

import java.util.List;

import com.fisi.unmsm.database.model.entity.ServiceBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br/>Interface Repository que define los métodos necesarios para gestionar
 * los datos del contexto Service Bill.<br/>
 *
 * <b>Interface</b>: ServiceBillRepository<br/>
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
public interface ServiceBillRepository extends CrudRepository<ServiceBill, Long> {

  List<ServiceBill> findByProvidedServiceId(Long providedServiceId);
}
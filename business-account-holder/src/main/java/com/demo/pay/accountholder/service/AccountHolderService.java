package com.demo.pay.accountholder.service;

import com.demo.pay.accountholder.util.model.dto.response.AccountHolderResponse;
import io.reactivex.Single;

/**
 * <br/>Interface Service que define los métodos necesarios para tramitar la lógica de negocio del
 * contexto Holder.<br/>
 *
 * <b>Interface</b>: HolderService<br/>
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
public interface AccountHolderService {

  Single<AccountHolderResponse> findById(Long holderId);
}

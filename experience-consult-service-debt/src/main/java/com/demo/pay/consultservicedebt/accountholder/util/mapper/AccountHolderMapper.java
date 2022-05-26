package com.demo.pay.consultservicedebt.accountholder.util.mapper;

import com.demo.pay.consultservicedebt.accountholder.util.model.dto.response.AccountHolderResponse;
import com.demo.pay.consultservicedebt.accountholder.util.model.dto.third.AccountHolderThird;
import org.mapstruct.Mapper;

/**
 * <br/>Interface Mapper que define los métodos necesarios para transferir la información de un modelo a otro
 * en el contexto Account Holder.<br/>
 *
 * <b>Interface</b>: AccountHolderMapper<br/>
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
@Mapper(componentModel = "spring")
public interface AccountHolderMapper {

  AccountHolderResponse fromThirdToResponse(AccountHolderThird accountHolder);
}

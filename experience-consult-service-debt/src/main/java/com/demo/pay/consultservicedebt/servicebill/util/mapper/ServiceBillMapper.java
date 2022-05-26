package com.demo.pay.consultservicedebt.servicebill.util.mapper;

import com.demo.pay.consultservicedebt.servicebill.util.model.dto.response.ServiceBillResponse;
import com.demo.pay.consultservicedebt.servicebill.util.model.dto.third.ServiceBillThird;
import org.mapstruct.Mapper;

/**
 * <br/>Interface Mapper que define los métodos necesarios para transferir la información de un modelo a otro
 * en el contexto Service Bill.<br/>
 *
 * <b>Interface</b>: ServiceBillMapper<br/>
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
public interface ServiceBillMapper {

  ServiceBillResponse fromThirdToResponse(ServiceBillThird providedService);
}

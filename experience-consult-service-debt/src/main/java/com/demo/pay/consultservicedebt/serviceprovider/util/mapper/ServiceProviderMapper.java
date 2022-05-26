package com.demo.pay.consultservicedebt.serviceprovider.util.mapper;

import com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import com.demo.pay.consultservicedebt.serviceprovider.util.model.dto.third.ServiceProviderThird;
import org.mapstruct.Mapper;

/**
 * <br/>Interface Mapper que define los métodos necesarios para transferir la información de un modelo a otro
 * en el contexto Service Provider.<br/>
 *
 * <b>Interface</b>: ServiceProviderMapper<br/>
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
public interface ServiceProviderMapper {

  ServiceProviderResponse fromThirdToResponse(ServiceProviderThird entity);
}

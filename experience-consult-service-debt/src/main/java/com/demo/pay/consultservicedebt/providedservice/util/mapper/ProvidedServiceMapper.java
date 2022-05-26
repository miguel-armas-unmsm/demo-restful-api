package com.demo.pay.consultservicedebt.providedservice.util.mapper;

import com.demo.pay.consultservicedebt.providedservice.util.model.dto.response.ProvidedServiceResponse;
import com.demo.pay.consultservicedebt.providedservice.util.model.dto.third.ProvidedServiceThird;
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
public interface ProvidedServiceMapper {

  ProvidedServiceResponse fromThirdToResponse(ProvidedServiceThird providedService);
}

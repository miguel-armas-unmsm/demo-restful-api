package com.demo.pay.providedservice.util.mapper;

import com.fisi.unmsm.database.model.entity.ProvidedService;
import com.demo.pay.providedservice.util.model.dto.response.ProvidedServiceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvidedServiceMapper {

  ProvidedServiceResponse fromEntityToResponse(ProvidedService providedService);
}

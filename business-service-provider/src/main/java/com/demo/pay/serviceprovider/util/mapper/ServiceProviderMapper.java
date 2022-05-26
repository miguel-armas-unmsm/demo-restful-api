package com.demo.pay.serviceprovider.util.mapper;

import com.fisi.unmsm.database.model.entity.ServiceProvider;
import com.demo.pay.serviceprovider.util.model.dto.response.ServiceProviderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceProviderMapper {

  ServiceProviderResponse fromEntityToResponse(ServiceProvider serviceProvider);
}

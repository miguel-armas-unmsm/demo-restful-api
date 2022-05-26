package com.demo.pay.servicebill.util.mapper;

import com.fisi.unmsm.database.model.entity.ServiceBill;
import com.demo.pay.servicebill.util.model.dto.response.ServiceBillResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceBillMapper {

  ServiceBillResponse fromEntityToResponse(ServiceBill serviceBill);
}

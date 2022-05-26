package com.demo.pay.accountholder.util.mapper;

import com.demo.pay.accountholder.util.model.dto.response.AccountHolderResponse;
import com.fisi.unmsm.database.model.entity.Holder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountHolderMapper {

  AccountHolderResponse fromEntityToResponse(Holder holder);
}

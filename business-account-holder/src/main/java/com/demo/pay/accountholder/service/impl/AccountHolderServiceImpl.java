package com.demo.pay.accountholder.service.impl;

import com.demo.pay.accountholder.util.mapper.AccountHolderMapper;
import com.demo.pay.accountholder.util.model.dto.response.AccountHolderResponse;
import com.demo.pay.accountholder.service.AccountHolderService;
import com.demo.pay.accountholder.repository.AccountHolderRepository;

import java.util.Objects;

import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del
 * contexto Holder.<br/>
 *
 * <b>Class</b>: HolderServiceImpl<br/>
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
@RequiredArgsConstructor
@Component
public class AccountHolderServiceImpl implements AccountHolderService {

  private final AccountHolderRepository accountHolderRepository;
  private final AccountHolderMapper accountHolderMapper;

  @Override
  public Single<AccountHolderResponse> findById(Long holderId) {
    return Single.just(Objects.requireNonNull(accountHolderRepository.findById(holderId)
        .map(accountHolderMapper::fromEntityToResponse).orElse(null)));
  }
}

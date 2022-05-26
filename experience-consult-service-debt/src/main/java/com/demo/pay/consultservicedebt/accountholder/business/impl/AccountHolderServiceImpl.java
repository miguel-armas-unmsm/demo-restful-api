package com.demo.pay.consultservicedebt.accountholder.business.impl;

import com.fisi.unmsm.support.retrofit.HttpStreamingTransformer;
import com.demo.pay.consultservicedebt.accountholder.business.AccountHolderService;
import com.demo.pay.consultservicedebt.accountholder.repository.proxy.AccountHolderProxy;
import com.demo.pay.consultservicedebt.accountholder.util.mapper.AccountHolderMapper;
import com.demo.pay.consultservicedebt.accountholder.util.model.dto.response.AccountHolderResponse;
import com.demo.pay.consultservicedebt.accountholder.util.model.dto.third.AccountHolderThird;
import com.demo.pay.consultservicedebt.util.constant.ErrorMessages;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.fisi.unmsm.support.logstash.Markers.SENSITIVE_TEXT;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio del
 * contexto Account Holder.<br/>
 *
 * <b>Class</b>: AccountHolderServiceImpl<br/>
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
@Slf4j
@RequiredArgsConstructor
@Component
public class AccountHolderServiceImpl implements AccountHolderService {

  private final AccountHolderProxy accountHolderProxy;
  private final AccountHolderMapper accountHolderMapper;

  @Override
  public Single<AccountHolderResponse> findById(Long id) {
    return accountHolderProxy.findById(id)
        .doOnError(error -> log.error(SENSITIVE_TEXT, ErrorMessages.ERROR_TO_CALL_ACCOUNT_HOLDER_PROXY, error))
        .compose(HttpStreamingTransformer.of(AccountHolderThird.class))
        .firstElement()
        .toSingle()
        .map(accountHolderMapper::fromThirdToResponse);
  }
}

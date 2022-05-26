package com.demo.pay.consultservicedebt.accountholder.repository.proxy;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.*;

/**
 * <br/>Interface Proxy que define los métodos necesarios para intermediar las peticiones hacia un cliente externo
 * en el contexto Account Holder.<br/>
 *
 * <b>Interface</b>: AccountHolderProxy<br/>
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
public interface AccountHolderProxy {

  @Headers({"Accept: application/stream+json"})
  @Streaming
  @GET("account-holders/{id}")
  Observable<ResponseBody> findById(@Path("id") Long id);

}

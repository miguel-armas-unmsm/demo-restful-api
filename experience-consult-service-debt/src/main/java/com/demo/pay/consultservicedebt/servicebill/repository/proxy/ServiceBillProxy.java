package com.demo.pay.consultservicedebt.servicebill.repository.proxy;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * <br/>Interface Proxy que define los métodos necesarios para intermediar las peticiones hacia un cliente externo
 * en el contexto Service Bill.<br/>
 *
 * <b>Interface</b>: ServiceBillProxy<br/>
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
public interface ServiceBillProxy {

  @Headers({"Accept: application/stream+json"})
  @Streaming
  @GET("service-bills")
  Observable<ResponseBody> findByProvidedServiceId(@Query("providedServiceId") Long providedServiceId);

}

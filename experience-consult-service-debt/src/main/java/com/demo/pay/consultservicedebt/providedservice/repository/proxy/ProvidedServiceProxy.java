package com.demo.pay.consultservicedebt.providedservice.repository.proxy;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * <br/>Interface Proxy que define los métodos necesarios para intermediar las peticiones hacia un cliente externo
 * en el contexto Provided Service.<br/>
 *
 * <b>Interface</b>: ProvidedServiceProxy<br/>
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
public interface ProvidedServiceProxy {

  @Headers({"Accept: application/stream+json"})
  @Streaming
  @GET("provided-services")
  Observable<ResponseBody> findByServiceProviderId(@Query("serviceProviderId") Long serviceProviderId);

}

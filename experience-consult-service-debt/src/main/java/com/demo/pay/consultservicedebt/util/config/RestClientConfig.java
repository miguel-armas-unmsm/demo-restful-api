package com.demo.pay.consultservicedebt.util.config;

import com.demo.pay.consultservicedebt.providedservice.repository.proxy.ProvidedServiceProxy;
import com.demo.pay.consultservicedebt.servicebill.repository.proxy.ServiceBillProxy;
import com.demo.pay.consultservicedebt.accountholder.repository.proxy.AccountHolderProxy;
import com.demo.pay.consultservicedebt.serviceprovider.repository.proxy.ServiceProviderProxy;
import com.fisi.unmsm.support.retrofit.SupportHttpClient;
import java.time.Duration;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br/>Clase Config que implementa la comunicación hacia los clientes externos de la aplicación.<br/>
 *
 * <b>Class</b>: RestClientConfig<br/>
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
@Configuration
public class RestClientConfig {

  @Value("${application.http-client.service-providers.base-url}")
  private String serviceProviderBaseUrl;

  @Value("${application.http-client.provided-services.base-url}")
  private String providedServiceBaseUrl;

  @Value("${application.http-client.service-bills.base-url}")
  private String serviceBillBaseUrl;

  @Value("${application.http-client.account-holders.base-url}")
  private String accountHolderBaseUrl;

  @Bean
  ServiceProviderProxy serviceProviderApi(OkHttpClient.Builder builder) {
    return SupportHttpClient.builder()
        .clientBuilder(builder)
        .baseUrl(this.serviceProviderBaseUrl)
        .connectTimeout(Duration.ofMillis(300L))
        .readTimeout(Duration.ofMillis(1200L))
        .writeTimeout(Duration.ofMillis(700L))
        .buildProxy(ServiceProviderProxy.class);
  }

  @Bean
  ProvidedServiceProxy providedServiceApi(OkHttpClient.Builder builder) {
    return SupportHttpClient.builder()
        .clientBuilder(builder)
        .baseUrl(this.providedServiceBaseUrl)
        .connectTimeout(Duration.ofMillis(300L))
        .readTimeout(Duration.ofMillis(1200L))
        .writeTimeout(Duration.ofMillis(700L))
        .buildProxy(ProvidedServiceProxy.class);
  }

  @Bean
  ServiceBillProxy serviceBillApi(OkHttpClient.Builder builder) {
    return SupportHttpClient.builder()
        .clientBuilder(builder)
        .baseUrl(this.serviceBillBaseUrl)
        .connectTimeout(Duration.ofMillis(300L))
        .readTimeout(Duration.ofMillis(1200L))
        .writeTimeout(Duration.ofMillis(700L))
        .buildProxy(ServiceBillProxy.class);
  }

  @Bean
  AccountHolderProxy accountHolderApi(OkHttpClient.Builder builder) {
    return SupportHttpClient.builder()
        .clientBuilder(builder)
        .baseUrl(this.accountHolderBaseUrl)
        .connectTimeout(Duration.ofMillis(300L))
        .readTimeout(Duration.ofMillis(1200L))
        .writeTimeout(Duration.ofMillis(700L))
        .buildProxy(AccountHolderProxy.class);
  }

  @Bean
  OkHttpClient.Builder client() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    return (new OkHttpClient.Builder()).addInterceptor((Interceptor)interceptor);
  }
}

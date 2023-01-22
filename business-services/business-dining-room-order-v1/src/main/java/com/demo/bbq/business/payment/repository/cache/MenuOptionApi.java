package com.demo.bbq.business.payment.repository.cache;

import com.demo.bbq.business.payment.util.model.dto.third.MenuOptionThird;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MenuOptionApi {

  @Headers({"Accept: application/json"})
  @GET("menu-options/{id}")
  Single<MenuOptionThird> findById(@Path(value = "id") Long id);
}

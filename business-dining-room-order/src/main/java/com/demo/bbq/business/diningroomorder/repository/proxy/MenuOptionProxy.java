package com.demo.bbq.business.diningroomorder.repository.proxy;

import com.demo.bbq.business.diningroomorder.util.model.dto.third.MenuOptionThird;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MenuOptionProxy {

  @Headers({"Accept: application/json"})
  @GET("menu-options/{id}")
  Observable<MenuOptionThird> findById(@Path(value = "id") Long id);
}

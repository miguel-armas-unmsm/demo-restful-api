package com.demo.bbq.menupurchase.menuoption.repository.proxy;

import com.demo.bbq.menupurchase.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.menupurchase.menuoption.util.model.dto.thirdparty.MenuOptionThird;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;
import java.util.List;

public interface MenuOptionProxy {

  @Headers({"Accept: application/json"})
  @GET("menu-options/{id}")
  Observable<MenuOptionThird> findById(@Path(value = "id") Long id);

  @Headers({"Accept: application/json"})
  @GET("menu-options")
  Observable<List<MenuOptionThird>> findByCategory(@Query("category") String category);

  @Headers({"Accept: application/json", "Content-Type: application/json"})
  @POST("menu-options")
  Observable<ResponseBody> save(@Body MenuOptionRequest menuOption);

  @Headers({"Accept: application/json", "Content-Type: application/json"})
  @PUT("menu-options/{id}")
  Observable<ResponseBody> update(@Path(value = "id") Long id, @Body MenuOptionRequest menuOption);

  @Headers({"Accept: application/json"})
  @DELETE("menu-options/{id}")
  Observable<ResponseBody> delete(@Path(value = "id") Long id);
}

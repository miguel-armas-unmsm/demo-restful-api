package com.demo.bbq.business.payment.repository.cache;

import com.demo.bbq.business.payment.util.model.dto.third.invoice.DiningRoomOrderThird;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DiningRoomOrderApi {

  @Headers({"Accept: application/stream+json"})
  @GET("dining-room-orders")
  Single<DiningRoomOrderThird> findByTableNumber(@Query("tableNumber") Integer tableNumber);
}

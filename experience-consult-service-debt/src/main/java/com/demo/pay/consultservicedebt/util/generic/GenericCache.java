package com.demo.pay.consultservicedebt.util.generic;

import com.demo.pay.consultservicedebt.util.exception.ExceptionCatalog;
import com.google.gson.Gson;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.adapter.rxjava.RxJava2Adapter;

@Repository
public class GenericCache<T> {

  @Qualifier("reactiveStringRedisTemplate")
  @Autowired
  private ReactiveRedisOperations<String, T> redisOperations;

  public Completable save(String hashName, String hashKey, T hashValue) {
    return RxJava2Adapter.monoToCompletable(redisOperations.<String, String>opsForHash()
        .put(hashName, hashKey, new Gson().toJson(hashValue)));
  }

  public Observable<T> findAllOfHash(String hashName, Class<T> actualClass) {
    return RxJava2Adapter.fluxToObservable(redisOperations.<String, String>opsForHash()
        .values(hashName))
        .cast(String.class)
        .map(json -> new Gson().fromJson(json, actualClass))
        .switchIfEmpty(Observable.error(ExceptionCatalog.ERROR0001.buildException()));
  }
}

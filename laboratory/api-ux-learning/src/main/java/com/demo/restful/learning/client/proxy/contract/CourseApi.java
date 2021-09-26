package com.demo.restful.learning.client.proxy.contract;

import com.demo.restful.learning.model.thirdparty.CourseResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import java.util.List;

/**
 * Interface API que define los métodos necesarios para consumir
 * los servicios del servidor cliente API BS Course.<br/>
 *
 * <p>Interface: CourseApi.<br/>
 *
 * @author Miguel Armas Abt <br/>
 * <u>Developed by</u>: Miguel Armas Abt<br/>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Set, 2021 Creación de Interface.</li>
 * </ul>
 * @version 1.0
 */
public interface CourseApi {

  @Headers({"Accept: application/json"})
  @GET("courses")
  Observable<List<CourseResponse>> findAll();
}

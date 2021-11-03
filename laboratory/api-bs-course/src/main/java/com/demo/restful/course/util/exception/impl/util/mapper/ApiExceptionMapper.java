package com.demo.restful.course.util.exception.impl.util.mapper;

import com.demo.restful.course.util.exception.impl.model.ApiException;
import com.demo.restful.course.util.exception.impl.model.ApiExceptionDetail;
import com.demo.restful.course.util.exception.impl.model.ApiExceptionDto;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * <br/>Clase Mapper que mueve la información de la excepción.<br/>
 *
 * <b>Class</b>: ApiExceptionMapper<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Oct, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
public class ApiExceptionMapper {

  private static final Function<List<ApiExceptionDetail>, List<ApiExceptionDetail>> buildDetails = details ->
      Optional.ofNullable(details).orElseGet(Collections::emptyList);

  public static Function<ApiException, ApiExceptionDto> buildApiExceptionResponse = ex ->
      ApiExceptionDto.builder(ex.getSystemCode(), ex.getDescription(), ex.getHttpStatus().toString())
          .properties(ex.getProperties())
          .exceptionDetails(buildDetails.apply(ex.getExceptionDetails()))
          .build();

}

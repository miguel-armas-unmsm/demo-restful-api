package com.demo.bbq.order.util.mapper;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.function.Function;

public class CommonMapper {

  private CommonMapper() {}

    public static Function<Long, URI> buildUriLocation = id -> ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();
}

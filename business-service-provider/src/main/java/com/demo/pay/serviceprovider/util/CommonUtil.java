package com.demo.pay.serviceprovider.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.function.Function;

public class CommonUtil {

  private CommonUtil() {}

    public static Function<Long, URI> buildUriLocation = id -> ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();
}

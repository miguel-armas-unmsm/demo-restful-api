package com.demo.bbq.menuoption.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class Util {

  private static final ObjectMapper mapper = new ObjectMapper();

  public static <T> T buildModelFromJson(String filename, Class<T> className) throws IOException {
    try {
      return mapper.readValue(Util.class.getClassLoader().getResourceAsStream(filename), className);
    } catch (Exception var3) {
      throw new RuntimeException(var3);
    }
  }

  static {
    mapper.findAndRegisterModules();
  }
}

package com.demo.pay.consultservicedebt.util.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.lang.reflect.Type;

/**
 * <br/>Clase Config que implementa la conexión con Redis.<br/>
 *
 * <b>Class</b>: RedisConfig<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
@RequiredArgsConstructor
@Configuration
public class RedisConfig<T> {

  private final RedisConnectionFactory redisFactory;

  private final ObjectMapper objectMapper;

  @Bean
  public ReactiveRedisTemplate<String, T> redisSerialization(
      ReactiveRedisConnectionFactory connectionFactory) {

    Type type = new TypeToken<T>(){}.getType();
    JavaType javaType = objectMapper.constructType(type);

    RedisSerializationContext<String, T> serializationContext = RedisSerializationContext
        .<String, T>newSerializationContext(new StringRedisSerializer())
        .hashKey(new StringRedisSerializer())
        .hashValue(new Jackson2JsonRedisSerializer<>(javaType))
        .build();
    return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
  }

}

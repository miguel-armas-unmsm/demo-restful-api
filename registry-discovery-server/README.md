# Registry Discovery Server
`autor`: Miguel Rodrigo Armas Abt

##Descripción
> Registry discovery server (Eureka) facilita la comunicación entre los microservicios mediante la invocación por sus nombres en lugar de una URL con su IP y su puerto. Esto supone una ventaja al evitar una gran cantidad de direcciones IP y puertos de manera estática, sobre todo en un escenario de escalamiento, ya que a medida que el ecosistema de microservicios vaya creciendo, el problema de gestión de direcciones IP y puertos crecerá con él. Por ello para un ambiente productivo se espera "escalado dinámico en dependencia de la carga de trabajo con instancias efímeras".

> http://127.0.0..1:9000/products ==> http://product-service/products

##Funcionalidad
> http://localhost:8761/

##Consideraciones
- Tener una versión de Spring Cloud compatible con nuestra versión de Spring Boot
  `spring boot compatibility`: https://spring.io/projects/spring-cloud

- Al contenerizar nuestra solución con Docker Desktop podríamos toparnos con errores de red, host.docker.internal.
  https://stackoverflow.com/questions/57319678/spring-boot-cloud-eurka-windows-10-eurkea-returns-host-docker-internal-for-clien
  
# Caso de estudio: Reactive BBQ
`<autor>`: Miguel Rodrigo Armas Abt

> Reactive BBQ es un restaurante que se enfoca en sabores tradicionales de barbacoa. Comenzó como una tienda familiar y 
> finalmente comenzó a crecer. Ellos habrían abierto un par de otras ubicaciones, luego tal vez se mudaron a algunas 
> ciudades diferentes, luego se mudaron por todo el país y ahora están en el punto en el que realmente se han 
> globalizado.

> El software es una gran parte de su negocio, sin embargo, lo que sucedió es que, el restaurante realmente creció y el 
> software creció orgánicamente con él, simplemente atornillaron cosas en diferentes lugares hasta el punto en que ahora
> tienen una aplicación que hace varias cosas. Hace de todo, desde la gestión de inventario hasta los precios del menú, 
> las entregas y los pedidos y reservas online. Todos estos se han agrupado en un solo sistema y lo que están 
> descubriendo ahora es que ese sistema realmente está luchando por su propio peso. Tienen muchos procesos heredados 
> relacionados con ese sistema antiguo y algunos de esos procesos heredados requieren que el sistema se apague durante 
> un período de tiempo. Cuando, por supuesto, el sistema se desactiva, significa que no pueden hacer cosas en sus 
> restaurantes, por lo que deben tratar de orientar ese tiempo de inactividad a períodos en los que no hay mucha 
> actividad en sus restaurantes o cuando los restaurantes están cerrados. Eso estaba bien cuando todas sus ubicaciones 
> estaban en América del Norte, pero a medida que se han globalizado, cada vez es más difícil encontrar esos períodos de
> tiempo en los que pueden tener tiempo de inactividad.

> Entonces El Reactive BBQ Restaurant, ahora está buscando arquitecturas para tratar de ayudar a resolver ese problema, 
> ya que está experimentando una importante actualización de su software. Buscan modernizar su monolito heredado 
> mediante la creación de nuevas piezas de la aplicación como microservicios.

## Expertos en el dominio
> Tras hablar con los expertos en el dominio restaurante e intentar entender su vocabulario para usarlo en nuestro 
> modelo pudimos identificar las siguientes actividades utilizando la notación sujeto-verbo-objeto.

- Anfitrión
    - El anfitrión verifica las reservas actuales.
    - El anfitrión crea una reserva para un cliente.
    - El anfitrión asienta al cliente con reserva.

- Mesero
    - El mesero toma el pedido.
    - El mesero entrega el pedido.
    - El mesero cobra el pago de un pedido.
  
- Chef de cocina
    - El chef de cocina prepara un pedido.
    - El chef de cocina notifica al mesero que el pedido está completo.
    - El chef de cocina inspecciona los pedidos.

- Conductor de delivery
    - El conductor recoge un pedido en el restaurante.
    - El conductor entrega un pedido al cliente.
    - El conductor cobra el pago de un pedido.

- Cliente en línea
    - El cliente en línea agrega elementos del menú a un pedido.
    - El cliente en línea realiza el pago de un pedido.
    - El cliente en línea hace una reserva.

## Bounded contexts
> De acuerdo a los objetos definidos en las actividades anteriores se identificaron los siguientes bounded contexts y 
> algunas palabras de sus lenguajes ubicuos.

- Reservation: reservation, table, customer, time, location
- Payment: credit, debit, cash
- Order: order, cook, notification, delivery, tip
- Menu: drink, plate, items
    
# Tecnologías de interés
Java 8, Retrofit, Lombok, Mapstruct, JUnit, Mockito, Eureka, Config Server, Docker

## Diferencia entre Spring Framework y Spring Boot
> Spring framework es un conjunto de herramientas para escribir aplicaciones Java que nos ofrece un conjunto de 
> platillas predefinidas para las principales funcionalidades como seguridad, persistencia, MVC y demás. Por otra parte
> Spring Boot es una extension de Spring Framework que incluye un servidor Tomcat embebido y nos libera de todas las 
> tareas repetitivas de configuración debido a la gran cantidad de starters (ficheros pom.xml preconfigurados) con todas
> las características necesarias para llevar a cabo ciertas tareas. Por ejemplo, el starter WEB trae el Tomcat embebido 
> que nos permite desplegar una aplicación web de manera sencilla. Así mismo, si se utiliza el starter JPA, se tiene las
> preconfiguraciones para trabajar con una base de datos.

`<Releases Spring Boot 2>`: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.6-Release-Notes

## Actuator
> Starter que pone a disposición endpoints que nos brindan información de las propiedades del microservicio, de su 
> propia configuración, de lo que está pasando en tiempo de ejecución, de la memoria que está utilizando, etc.

## Docker
> Docker es un contenedor donde empaquetamos toda nuestra solución y después la podemos administrar de una manera 
> sencilla. Es portable y no depende del SO o de sus aplicaciones, por eso garantiza que nuestra solución no va a 
> depender de lo que haya en un servidor o un equipo instalado, solamente de lo que esté dentro el contenedor.

> Una imagen es una plantilla donde nosotros indicamos cómo crear un contenedor (librerías, archivos, variables, etc.).

> ¿Qué necesita el SO para ejecutar nuestro contenedor? Necesita un Docker Engine, que ejecute los contenedores, en los 
> cuales se almacenan nuestras aplicaciones. Docker engine se encarga de hacer la gestión de recursos de cada una de las
> aplicaciones de acuerdo a lo que necesite el SO.

> Un orquestador, que gestione (despliegue, red, etc) todos los microservicios por lo general sería Kubernetes, pero 
> para efectos prácticos este proyecto utiliza Docker Compose. La version Docker Compose debe estar alineado a Docker 
> Engine (3.8 - 19.03)

```javascript

$ java -jar directory/target/application-0.0.1-SNAPSHOT.jar // ejecutar un proyecto de java
$ docker images                         //listar imágenes 
$ docker image ls                       //listar imágenes 
$ docker container ls                   //listar los contenedores activos 
$ docker ps                             //listar los contenedores activos 
$ docker ps -a                          //listar todos los contenedores
$ docker container --help               //listar comandos para containers 
$ docker logs -f [CONTAINER_NAMES]      //ver logs 
$ docker rmi -f [IMAGE_NAME:VERSION]    //eliminar imagen 
$ docker rm [CONTAINER_ID]              //eliminar container  
$ docker compose up -d                  //ejecutar el fichero docker-compose.yaml
$ docker compose up -d --force-recreate //ejecutar el fichero docker-compose.yaml
$ docker-compose start                  //iniciar los servicios que no están iniciados
$ docker-compose stop                   //detener los servicios que están iniciados
$ docker start [CONTAINER_NAMES]

```

Volumes y mapeo de puertos
https://youtu.be/GwnDA-oXShI

- revisar video 50, cambio de perfiles y base de datos postgress (variables de entorno Dspring.profiles)
- 

## API
> Mecanismo que permite a dos componentes de software comunicarse entre sí mediante un conjunto de definiciones y 
> protocolos. Ejm. API de SOAP, API de RPC, API de WebSocket, API de REST

## API GATEWAY
> Componente intermediario que proporciona una interfaz para hacer de enrutador entre los servicios y los consumidores 
> desde un único punto de entrada. Si pensamos en una arquitectura de servicios distribuidos, habrá numerosos clientes 
> que necesitarán intercomunicarse para completar las operaciones que se les soliciten. A medida que el número de 
> servicios crece, es importante que exista un intermediario que simplifique la comunicación entre los distintos 
> clientes y servicios del sistema, en lugar de hacerlo de forma directa. Es aquí donde entra en juego el API Gateway, 
> encargado de gestionar tareas como por ejemplo: 
> - Políticas de seguridad como sistemas de autenticación o protección contra amenazas
> - Enrutamiento
> - Monitorización del tráfico de entrada y salida
> - Escalabilidad

## API MANAGEMENT
> Proceso de crear y publicar APIs, hacer cumplir sus políticas de uso, controlar el acceso, nutrir la comunidad de 
> suscriptores, recopilar y analizar estadísticas de uso y rendimiento.
https://www.youtube.com/watch?v=fh3VaXLzH5Y

## ESTÁNDARES PARA EL DISEÑO DE APIS
> Diseñar una solución óptima aplicando los diferentes estándares que impone la industria
> Es habitual que en una compañía se tengan diferentes equipos trabajando en microservicios y cada uno va a utilizar las 
> tecnologías que más le convenga, sin embargo deberíamos tener todos en común son los estándares y las buenas prácticas 
> de la industria para que la comunicación entre los microservicios sea más sencilla de implementar

> Los microservicios implementan APIs y sobre ellas hay dos elementos importantes:
> - Códigos de respuesta
> - Manejo de excepciones centralizadas

> Los RFC son estándares de ingenería creados por el Grupo de Trabajo de Ingenería de Internet (IETF)
https://www.rfc-editor.org/rfc/rfc7231
https://tools.ietf.org

rfc7231 HTTP STATUS CODES

> Literatura profesional para diferenciarnos del desarrollador promedio
https://spec.openapis.org/oas/v3.0.3#http-status-codes
https://cloud.google.com/files/apigee/apigee-web-api-design-the-missing-link-ebook.pdf

rfc7807 EXCEPTIONS





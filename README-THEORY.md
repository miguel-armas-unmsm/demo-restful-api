# Spring Boot y Spring Cloud
`<autor>`: Miguel Rodrigo Armas Abt

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
> - **Docker**: Contenedor donde empaquetamos toda nuestra solución y después la podemos administrar. Es portable y no 
> depende del SO o de sus aplicaciones, por eso garantiza que nuestra solución no va a depender de lo que haya en un 
>servidor o un equipo instalado, solamente de lo que esté dentro el contenedor.
>
> - **Imagen**: Plantilla donde indicamos cómo crear un contenedor (librerías, archivos, variables, etc.).
>
> - **Docker Engine**: ¿Qué necesita el SO para ejecutar nuestro contenedor? Necesita un Docker Engine, que ejecute los 
> contenedores, en los cuales se almacenan nuestras aplicaciones. Docker engine se encarga de hacer la gestión de 
> recursos de cada una de las aplicaciones de acuerdo a lo que necesite el SO.
>
> - **Orquestador**: Un orquestador, que gestione (despliegue, red, etc) todos los microservicios por lo general sería 
> Kubernetes, pero para efectos prácticos este proyecto utiliza Docker Compose. La version Docker Compose debe estar 
> alineado a Docker Engine (3.8 - 19.03)

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
$ docker compose up -d --force-recreate //forzar la ejecución del fichero docker-compose.yaml
$ docker-compose start                  //iniciar los servicios que no están iniciados
$ docker-compose stop                   //detener los servicios que están iniciados
$ docker start [CONTAINER_NAMES]

$ docker-compose -f docker-compose.yml up -d keycloak-server
```

Volumes y mapeo de puertos
https://youtu.be/GwnDA-oXShI

- revisar video 50, cambio de perfiles y base de datos postgress (variables de entorno Dspring.profiles)


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
> Es habitual que las compañías tengan diferentes equipos trabajando en distintos microservicios. Ante ello es 
> importante seguir estándares y buenas prácticas impuestas por la industria para diseñar una solución óptima. Los RFC 
> son estándares de ingenería creados por el Grupo de Trabajo de Ingenería de Internet (IETF) y darán un respaldo 
> profesional a nuestras soluciones. Por ejemplo:
> - Códigos de estado HTTP: https://www.rfc-editor.org/rfc/rfc7231
> - Estructura de las excepciones: https://www.rfc-editor.org/rfc/rfc7807
> 
> Lecturas adicionales: 
> - https://spec.openapis.org/oas/v3.0.3#http-status-codes
> - https://cloud.google.com/files/apigee/apigee-web-api-design-the-missing-link-ebook.pdf

## SEGURIDAD
> Existen diversos proveedores de autorización y autenticación (keycloack)

## BALANCEO DE CARGA

## SERVIDOR PROXY
> Aplicación de servidor que actúa como un mediador de las peticiones que realiza un cliente y los recursos que 
> provienen de un servidor. Su propósito es que no haya comunicación directa entre el cliente y los recursos del 
> servidor a los que quiere acceder, de tal manera que cuando el cliente vaya a salir a internet no exponga su dirección
> IP y todos los detalles, sino que salga enmascarado. Así mismo cuando regresen los recursos de esa petición no vayan 
> directo al cliente, sino que primero pase por el proxy. El motivo de utilizar proxy es cubrir principalmente funciones
> como:
> - **Caché**: El contenido de las peticiones se guardan de manera temporal con una tasa de refresco, de modo que la 
> siguiente petición al mismo recurso se recupera desde caché haciendo más rápida la petición.
> 
> - **Filtrado**: Bloquear acceso a cierto contenido dentro de una red.
> 
> - **Anonimato**: Ya que no existe comunicación directa entre el cliente y recursos del servidor, se pueden encapsular 
> las peticiones y lograr cierto grado de anonimato.
>
> Existen dos tipos de servidores proxy y su diferencia está en el sentido en que se quiere filtrar las peticiones
> - **Forward proxy** (proxy de reenvío)
>   - Utilizado por las compañías para restringir contenido
>   - Filtra las peticiones de los usuarios dentro de la compañía para salir a internet.
> 
> - **Reverse proxy** (proxy inverso)
>   - Controla el tráfico entrante a las aplicaciones
>   - Filtra las peticiones de las aplicaciones desde internet para acceder a las funcionalidades (microservicios)
>   - En un contexto de microservicios, identifica las peticiones entrantes, aplica políticas de seguridad, balanceo de 
      cargas para redirigir el tráfico, cache, monitorización.

## PROXY INVERSO
> Existen múltiples técnicas y productos para implementar un proxy inverso en dependencia de la arquitectura, 
> infraestructura y tamaño de la solución. Por ejemplo, en una infraestructura cloud, los cloud providers (Azure, Google 
> o AWS) suelen ofrecer un servicio de proxy inverso (para soluciones con cientos de microservicios) que es diferente a
> un proxy inverso diseñada para una solución desplegada en un cluster de kubernetes o Docker Swarm (con 10 o 20 
> microservicios).
>
> Existen diferentes productos para implementar un proxy inverso:
> - NGINX: Servidor proxy inverso más común
> - WS02: Implementa el proxy inverso mediante el patrón API Gateway
> - Istio: Implementa el proxy inverso mediante el patrón Service MESH
> - Spring Cloud Gateway
>
> El modelo de referencia OSI separa por capas las comunicaciones de red. Las capas de interés para un proxy inverso son
> la capa 4 (transporte) y la capa 7 (aplicación). En tal sentido, el proxy inverso como un enfoque de arquitectura
> tiene dos patrones principales, API Gateway y Service MESH, los cuales pueden complementarse. Estos patrones se 
> diferencian por el modo en que se comunican las  aplicaciones. La principal diferencia que tienen es en el despliegue.
> 
> - API Gateway:
>     - Despliegue centralizado, con un único punto de fallo. Se coloca una aplicación en frente de todos los 
> servicios de la solución y todo el tráfico de peticiones debe pasar por allí.
>     - Opera y establece comunicación únicamente con el protocolo HTTP sobre TCP/IP mediante APIs.
>     - Tráfico de norte a sur (desde internet hacia la red interna de la compañía con sus aplicaciones)
>     - Relacionado con la disciplina API Management
>     - Hay múltiples maneras para cerrar la conexión desde internet hacia las APIs. Depende de la infraestructura y el
> despliegue. Lo ideal es que haya un firewall que anule las peticiones que vienen desde fuera del API gateway. En este
> caso de uso no se puede implementar un firewall, pero se puede aprovechar las bondades de Eureka asignando un puerto
> aleatorio que solo el API Gateway conozca para cada servicio.
>     - Para es caso de uso se hace uso de load balancing para descubrir las instancias correctas de cada servicio, dado
> que no se conocen sus puertos.
> 
> - Service MESH:
>     - Despliegue descentralizado. Se despliega una instancia del service mesh al lado de cada uno de los servicios,
> dentro del mismo host (pod o instancia de vm).
>     - Dado que opera en un nivel más bajo, en la capa 4 (capa de transporte), añade funcionalidades más específicas
> como el cifrado.
>     - Tráfico de este a oeste (flujo de tráfico en la red interna de la compañía, normalmente entre servicios o bd)
>
>
## API Gateway y seguridad
> El Api gateway permite aplicar políticas de seguridad para acceder a los recursos de nuestra aplicación mediante 
> peticiones autenticadas provenientes de la aplicación cliente. Esto implica centralizar el proceso de autenticación en
> el Api gateway mediante un adaptador (Keycloack adapter) que permita conectar con un proveedor de autenticación (SOO, 
> Oauth2). 
> 
> De este modo, cuando la aplicación cliente quiera acceder a cualquier recurso de nuestra aplicación primero debe 
> solicitar un token (request access token) al provedoor de autenticación y enviarlo en la petición al API Gateway a
> través de la cabecera Authorization. En este punto todas las peticiones que se envíen al API Gateway sin el header 
> Authorization serán rechazadas con un error de autenticación 401. A continuación, el API Gateway utilizará el servicio
> adaptador para que se conecte con el proveedor de auntenticación y este último valide el token de acceso (que no haya.
> expirado, que sea del usuario correcto, que se haya emitido con la firma correcta, etc.). Finalmente, una vez que se
> verifica que el token es válido entonces el API Gateway redirige la petición al recurso que se esté solicitando.
> 
> Cuando se emite el token, se emiten dos tokens, el primero es el request access token y el segundo se conoce como 
> refresh token porque cuando los primeros tokens caducan, se debe enviar el token de refresco para hacer la solicitud
> de un nuevo token. A continuación cada aplicación se encarga de almacenar de manera interna ambos tokens y estar 
> verificando constantemente si el primer token ha caducado.
>
## Proveedor de autenticación (Keycloak)
> - Proveedor de autenticación: Existen múltiples proveedores para el proceso de autenticación (comprobar credenciales
> del usuario) y autorización (privilegios sobre diferentes recursos). Los proveedores más populares están en cloud 
> (AWS, Google, Azure). También hay otros proveedores independientes de la plataforma (Keycloak) que sirven para 
> trabajar en onepremise o cloud e incluso hay la posibilidad de implementar uno propio considerando todo el proceso de 
> autenticación, gestión de tokens, recursos y demás. Sin embargo, esto último no es una buena práctica, ya que hoy por 
> hoy existen soluciones open source que podemos utilizar (Keycloak). Finalmente, Oauth2, Single Sign On (SSO) son 
> protocolos estándar que implementan los proveedores de autenticación.
>
> - Keycloak: Single Sign On. Una de las ventajas de Keycloak es que podemos conectarlo con proveedores de identidad 
> como Google, Facebook, Github, LDAP para redirigir la autenticación a estas otras soluciones. Por lo general, las 
> empresas que no utilizan cloud hacen uso de Keycloak.
> 
## Oauth2
> Protocolo o estándar de autorización en el que ciertos recursos de una aplicación son controlados por un usuario y que
> su control necesita ser delegado a otras aplicaciones cliente, pero sin la necesidad de que estas aplicaciones cliente
> conozcan las credenciales involucradas en el proceso (username y password). El flujo Oauth2 parte del supuesto de que 
> el usuario ya está registrado (en Facebook, Keycloack, etc.), tiene un nombre de usuario y una contraseña y tiene una
> lista de los recursos que tiene asignados. 
>
## OpenID Connect
> Protocolo que hace parte de Oauth2. Se encarga de autenticar al usuario con nombre de usuario y contraseña, luego 
> devolver un token que pueda ser utilizado por otras aplicaciones que necesiten tener control sobre los recursos 
> delegados dentro del proceso de Oauth2.
>
## Single Sign On (SSO)
> Mecanismo que permite que el usuario se loguee una sola vez en una aplicación SSO y que en consecuencia se loguee en 
> las demás aplicaciones que forman parte del proceso.
>
## Keycloak

### Realm
> Área funcional dentro de la compañía, donde se agrupará ciertos usuarios, aplicaciones y demás. Por defecto viene
> el realm master, pero no es una buena práctica trabajar sobre este, así que creamos el nuestro. Cabe mencionar que 
> este es un concepto propio de Keycloak y que podría variar para otros proveedores, pero con configuraciones similares.
#### Keys
> Para configurar la comunicación entre Keycloak y nuestro servicio adaptador es necesaria la llave pública brindada 
> por Keycloak que permite firmar los tokens. Para este caso de uso, en la sección 'Keys' de 'Realm Settings' ocuparemos
> RS256 sin encriptar.
#### Tokens
> Se pueden configurar las características del token desde la sección 'Tokens' de 'Realm Settings'. Por ejemplo,
> podemos cambiar el tiempo de vida del token alterando el campo 'Access Token Lifespan'.
> 
## Roles y usuario
> Creamos un rol, un usuario al cual le asignamos credenciales y el rol creado.
## Clients
> Creamos un cliente, el cual tiene una característica obligatoria (Valid Redirect URIs = *). Este cliente representa el
> frontend de todos nuestros servicios.
>
### Conclusión:
> El usuario que definimos representa al usuario que se autentica desde el cliente frontend, el cual obtiene un token 
> del proveedor de SSO y lo utiliza para realizar peticiones a los servicios que están por detrás. Así mismo, al usuario
> se le asignó un rol que fue creado dentro de nuestro reino (realm), el cual podría representar el departamento de 
> RRHH, Informática, Ventas, etc. o algún otro grupo que haga sentido a la clasificación en la empresa.

## Patron filter e interceptor de Java
https://www.oracle.com/java/technologies/intercepting-filter.html

> El api gateway aplica filtros (clases que extienden de AbstractGatewayFilterFactory) a las peticiones antes de 
> redirigirlas a los servicios.

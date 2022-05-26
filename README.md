### Reactive Consult Service Debt
`<repositorio>` : <>

`<autor>`: Miguel Rodrigo Armas Abt

##Descripción del proyecto
#### Consideraciones funcionales
> * Una empresa proveedora ofrece uno o muchos servicios.
* Un cliente puede consumir los servicios ofrecidos por las empresas proveedoras.
* Los servicios generan una o muchas deudas.
* El cliente tiene asignada una cuenta para pagar el servicio que ha consumido.

#### Consideracion técnicas
> * El API consult-service-debt consume las diversas APIs de negocio de forma reactiva, vale decir, mediante application/stream+json.
* El API consult-servide-debt almacena la respuesta de las APIs de negocio business-service-providers y business-provided-services en una caché distribuida.
* Tecnologías de interés: RxJava2, Retrofit, Redis, Lombok, Mapstruct

##Prerrequisitos para instalación y despliegue
* Java 11
* Maven 3.8.1
* Habilitar plugin de Lombok
* Redis

##Instalación
* Abrir los proyectos database-model y support, de preferencia en el IDE IntelliJIDEA y realizar un $mvn clean install para instalar las dependencias en el repositorio local de Maven.
* Habilitar el servicio de Redis y dejarlo corriendo.
* Por defecto, las APIs business se conectarán a MySQL, pero se puede cambiar de gestor de base de datos cambiando el archivo de propiedades (application.yaml)
* Para insertar data de prueba en cada caso copiar, pegar y ejecutar las instrucciones SQL que están en el archivo data.sql ubicado en el paquete test/resources.
* Finalmente probar las APIs business mediante postman, seguido de la API experience.
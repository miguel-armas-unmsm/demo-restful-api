### Menu Options
`<repositorio>` : <>

`<autor>`: Miguel Rodrigo Armas Abt

##Descripción del proyecto
#### Consideraciones funcionales
> * Gestión de opciones de menú (CRUD).

#### Consideracion técnicas
> * El API experience-menu-purchase consume la API de negocio mediante REST, vale decir, mediante application/json.
* La API de negocio accede a una base de datos relacional para gestionar las opciones de menú.
* Aplica pruebas unitarias
* Tecnologías de interés: Java 8, Retrofit, Lombok, Mapstruct, JUnit, Mockito

##Prerrequisitos para instalación y despliegue
* Java 11
* Maven 3.8.1
* Habilitar plugin de Lombok

##Instalación
* Por defecto, la APIs de negocio se conectará a MySQL, pero se puede cambiar de gestor de base de datos cambiando el archivo de propiedades (application.yaml)
* Para insertar data de prueba en cada caso copiar, pegar y ejecutar las instrucciones SQL que están en el archivo data.sql ubicado en el paquete test/resources.
* Finalmente probar la APIs business mediante postman, seguido de la API experience.
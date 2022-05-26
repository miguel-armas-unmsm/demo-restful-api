### Experience API Menu Purchase
`<repositorio>` : <https://github.com/miguel-armas-unmsm/demo-restful-api/tree/crud/experience-menu-purchase>

`<autor>`: Miguel Rodrigo Armas Abt

##Acerca de la funcionalidad
| Endpoint | Método | Descripción
| ------------- | ------------------------------ |---------- |
| `/bbq/business/v1/menu-options?category={category}`| GET | Recupera todas las opciones de menú, filtrados por categoría si se envía el query param category.|
| `/bbq/business/v1/menu-options/{id}`| GET | Recupera una opción de menú por id.|
| `/bbq/business/v1/menu-options`| POST | Almacena una nueva opción de menú.|
| `/bbq/business/v1/menu-options/{id}`| PUT | Actualiza un registro de opción de menú.|
| `/bbq/business/v1/menu-options/{id}`| DELETE | Elimina un registro de opción de menú.|

##Fuente de datos
> Se comunica con la API business-menu-options

##Prerrequisitos para instalación y despliegue
* Java 11
* Maven 3.8.1
* Habilitar plugin de Lombok
* Docker

##Pruebas unitarias
> No aplica.
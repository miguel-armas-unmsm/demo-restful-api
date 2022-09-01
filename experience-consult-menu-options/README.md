# Experience API Consult Menu Options
`<autor>`: Miguel Rodrigo Armas Abt

`documentación` : <http://localhost:8094/swagger/swagger-ui/index.html>

##Acerca de la funcionalidad
| Endpoint | Método | Descripción
| ------------- | ------------------------------ |---------- |
| `/bbq/business/v1/menu-options?category={category}`| GET | Recupera todas las opciones de menú, filtrados por categoría si se envía el query param category.|
| `/bbq/business/v1/menu-options/{id}`| GET | Recupera una opción de menú por id.|
| `/bbq/business/v1/menu-options`| POST | Almacena una nueva opción de menú.|
| `/bbq/business/v1/menu-options/{id}`| PUT | Actualiza un registro de opción de menú.|
| `/bbq/business/v1/menu-options/{id}`| DELETE | Elimina un registro de opción de menú.|

##Fuente de datos
> Se comunica con el cliente http business-menu-options

##Pruebas unitarias
> Aplica.
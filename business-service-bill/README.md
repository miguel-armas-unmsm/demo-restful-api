### Business API Service Bills
`<repositorio>` : <>

`<autor>`: Miguel Rodrigo Armas Abt

##Acerca de la funcionalidad
| Endpoint | Método | Descripción
| ------------- | ------------------------------ |---------- |
| `/pay/business/v1/service-bills?providedServiceId={providedServiceId}`| GET | Recupera todas las deudas asociadas a un servicio.|

##Fuente de datos
> Tiene acceso a la tabla service_bills.

##Prerrequisitos para instalación y despliegue
* Java 11
* Maven 3.8.1
* Habilitar plugin de Lombok
* Docker

##Pruebas unitarias
> No aplica.
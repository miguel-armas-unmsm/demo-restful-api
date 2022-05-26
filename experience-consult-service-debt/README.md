### Experience API Consult Service Debt
`<repositorio>` : <>

`<autor>`: Miguel Rodrigo Armas Abt

##Acerca de la funcionalidad
| Endpoint | Método | Descripción
| ------------- | ------------------------------ |---------- |
| `/pay/experience/v1/service-providers`| GET | Recupera todas las empresas proveedoras.|
| `/pay/experience/v1/provided-services?serviceProviderId={serviceProviderId}`| GET | Recupera todas los servicios asociados a una empresa proveedora.|
| `/pay/experience/v1/service-bills?providedServiceId={providedServiceId}`| GET | Recupera todas las deudas asociadas a un servicio.|
| `/pay/experience/v1/account-holders`| GET | Recupera el detalle de la cuenta.|

##Fuente de datos
> Se comunica con las siguientes APIs:
* business-service-providers
* business-provided-services
* business-service-bills
* business-account-holders

##Prerrequisitos para instalación y despliegue
* Java 11
* Maven 3.8.1
* Habilitar plugin de Lombok
* Docker

##Pruebas unitarias
> No aplica.
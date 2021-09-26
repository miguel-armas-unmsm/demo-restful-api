# API BS Course
API RESTful de negocio.

## Pre requisitos

### Plugins:
* [Lombok] (http://projectlombok.org/) - *Librería de Bytecode que genera automáticamente los getters y setters*
* [Checkstyle] (http://www.checkstyle.com/) - *Plugin para poder comprobar el estilo del código usando las reglas de Google*

### Acceso a datos:
Se accede a la base de datos relacional H2, tablas:
- course
    
## Consumo:
* Ejecutar el siguiente comando:
``
  curl --location --request GET 'http://localhost:8093/demo/business/v1/courses'
``

## Covertura de pruebas unitarias:
No aplica.

## Despliegue
No aplica.

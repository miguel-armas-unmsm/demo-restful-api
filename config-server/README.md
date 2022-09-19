# Config Server
`autor`: Miguel Rodrigo Armas Abt

## Descripción
> Config Server centraliza las propiedades de los proyectos en un repositorio de Git y es útil para separar las 
> propiedades de acuerdo al entorno de ejecución (desarrollo, qa, producción), ya que es posible que algunas 
> propiedades cambien entre uno u otro ambiente, como por ejemplo contraseñas, URL, IPs, constantes, etc. De este modo 
> al ejecutar nuestro microservicio basta con indicar una variable de entorno que utilice el perfil de desarrollo o 
> producción.

## Consideraciones
- Los ficheros de propidades deben estar en la misma ruta que .git
- Se debe considerar un prefijo y un sufijo en la nomenclatura de los archivos de propiedades
    - business-menu-option-dev
    - experience-consult-menu-option-dev
- Para validar la conexión con los archivos de propiedades:
    - http://localhost:8888/business/menu-option-dev
    - http://localhost:8888/experience/consult-menu-option-dev
- Los clientes del config server deben utilizar un fichero llamado bootstrap.yaml, el cual es primer fichero de configuración que SpringBoot llama al arrancar la aplicación



# Examen entrevista Momentous

Proyecto para entrevista en Momentous


# Ejecución del Proyecto

En la raíz del proyecto ejecutar
> mvn spring-boot:run
Esto compilará y ejecutara el plugin de Spring Boot

## Probar servicios

Ir a:
> http://localhost:8080/menu/

Está hecho de forma que en este endpoint se devuelvan todos los menues, paginados de a 20 y ordenados de forma descendiente por id de menú.


## Arquitectura

- Se utilizó Spring Boot, Maven, tiene una base de datos embebida HSQL, para consultas y filtrado de datos se utilizó Jpa y Spring Data

- El código se divide en las capas de:

  - Rest : Controller
  - Service : Interfaces e implementaciones necesarias para conectar la capa de acceso a datos
  - Repository : Capa de acceso a datos
  - Entity : Entidades de la aplicación


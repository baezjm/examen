# Examen entrevista Momentous

Proyecto para entrevista en Momentous


# Ejecución del Proyecto

En la raíz del proyecto ejecutar
> mvn spring-boot:run
Esto compilará y ejecutara el plugin de Spring Boot

También se puede clonar el proyecto desde este repositorio y levantarlo en intellij. Dar en open y seleccionar el pom.xml del mismo.

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

## Listado

Se puede filtrar por los atributos solicitados en la especificación, de la siguiente forma
> curl 'localhost:8080/menu/?fromHour=12&fromMinute=20&toHour=16&toMinute=00&fromValidDate=2016-01-01&toValidDate=2016-06-30&day=monday'

Si un atributo no va en el filtro directamente no se lo tiene en cuenta. Esto se realizó utilizando Specifications.

Además del filtrado la respuesta del listado también se puede paginar, mediante la utilización parámetros específicos. Por ejemplo:

> curl 'localhost:8080/menu/?fromHour=12&fromMinute=20&toHour=16&toMinute=00&fromValidDate=2016-01-01&toValidDate=2016-06-30&page=1&size=1&sort=fromHour,desc'

## Documentación

Se añadió a modo de prueba una pequeña documentación con swagger 2, no está completa, pero es únicamente para mostrar este agregado. Para acceder a la misma ir a:

> http://localhost:8080/swagger-ui.html

## Librería Extra

Para facilitar el desarrollo, se utilizó una librería que permite pasar por parámetros Specifications de Spring, la misma se podría desarrollar totalmente en el código ya que utiliza las mismas tecnologías. El proyecto se encuentra en el siguiente repositorio de github

> https://github.com/tkaczmarzyk/specification-arg-resolver

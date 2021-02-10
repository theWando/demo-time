# Ejemplo en Spring boot y trabajando con fechas
Este pequeño proyecto nace como motivo el enseñar por que es recomendable trabajar con 
las clases en el paquete `java.time` y no con las que existen en `java.util` al momento 
en que vamos a estar trabajando con fechas. 

En primer lugar este proyecto se apoya en Spring boot por que es bastante fácil hacer
la construcción de un proyecto que puede separarse en perfiles y cargar una configuración
particular separando los contextos para el uso con `java.util.Date` y `java.time`.

## ¿Cual es el problema con la implementación de `java.util.Date`?

En un articulo de Oracle sobre el tema se escribe lo siguiente:

>Un problema de larga data de los desarrolladores de Java ha sido el soporte inadecuado para los casos de uso 
> de fecha y hora de los desarrolladores normales.

### ¿Las razones?

* Varias clases tales como `java.util.Date` y `java.text.SimpleDateFormat` no son "thread-safe" y se traduce en 
posible problemas de concurrencia.
* Algunas clases tienen un diseño confuso y pobre, ejemplo:
    * Los años comienzan en 1900.
    * Los meses inician en 1.
    * Los días de la semana en `java.util.Date` parten en `0`.
  
Debido a estos errores en el diseño de `java.util.Date` muchos de sus métodos fueron deprecados desde
la versión `1.1` y se portaron a clases como `java.util.Calendar` y `java.util.GregorianCalendar`.

### ¿Que es `Date`?

Es importanten entender que `Date` representa un punto en el tiempo, no una fecha, eso quiere decir que:

* No tiene Huso Horatio.
* No tiene formato.
* No tiene sistema de Calendario.
* El tiempo no debe ser mutable, pero `Date` lo es.

#### ¿Que es un punto en el tiempo?

Es importante comprender la diferencia de un momento, un instante o un punto en el tiempo y como se separa de una fecha,
por ejemplo si nos referimos al alunizaje.

Neil Armstrong caminando en la luna, un evento que todo el mundo pudo verlo en vivo, un evento que muchas personas 
pudieron ver en distintas fechas (husos horario y calendarios).

* Houston: Julio 20 1969, 9:56:20 pm CDT
* Londres: Julio 21 1969, 3:26:20 am BST
* Riyadh (Arabia Saudita): Jumādá 7 1389, 5:56:20 am (+03)

### ¿Que es un punto en el tiempo?

En muchos lenguajes se define como un instante (`java.time.Instant` desde Java 1.8) y casi todos derivan sun 
implementación de `Unix epoch` y que se representa como una cantidad de tiempo antes o después de un punto en 
el tiempo, especialmente el 1ro de Enero de 1970 UTC.

Este concepto es usado por la clase `Date` al hacer uso del método `getTime()` o el constructor `Date(long)` o el 
setter `setTime()`. Volviendo al alunizaje su instante es: `-14159020000`.

Commit Strip hizo una buena explicación sobre este 
[concepto](https://www.commitstrip.com/en/2016/01/14/a-story-about-timestamp-and-timezone/?).

## ¿Que soluciona el paquete `java.time`?

Para poder dar solución el equipo encargado de Java se involucró con el creador de Joda-Time Stephen Colebourne
y teniendo como resultado el [JSR 310](https://jcp.org/en/jsr/detail?id=310) y al final la creación del paquete 
`java.time` para la versión 8 de Java. Entre las mejoras están:

* Clases de valor-inmutable; y por consecuencia son thread-safe, solucionando también uno de las debilidades mas serias 
  de algunos formateadores como `SimpleDateFormat`.
* Domain Driven Design; diseñando la API de forma específica y dando soporte a casos de usos para fechas y horas.
* Separación de calendarios; el nuevo diseño da soporte a calendarios que no son compatibles con ISO-8601, 
  como los usados en Japón, Thailandia o Arabia Saudita.

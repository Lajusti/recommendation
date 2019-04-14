# recommendation

Proyecto de recommendation por Alejandro Lajusticia Delgado

## Setup

Este proyecto requiere **gradle**


Una vez que el proyecto compile, al bajar todas las dependencias de gradle y tener configurado correctamente lombok, se puede levantar el proyecto directamente desde el IDE y ocupara el puerto **80**.

He generado el bootjar resultante en el directorio: **/bootjar** se puede ejecutar mediante **$java -jar ./bootjar/recommendation-1.0.0.jar**

## REST-API ENDPOINTS

### [GET] localhost/tags - Ver todas las tags con las tags potenciales de cada una

### [GET] localhost/tags/{tagId} - Obtener las tags potenciales de una tag concreta

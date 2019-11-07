# Practica 1

Una de las principales aplicaciones de la bioinformática es la representación de secuencias genéticas. Una
secuencia genética es una sucesión de letras representando la estructura primaria de una molécula real o
hipotética de ADN o ARN o banda, con la capacidad de transportar información. En el caso del ADN las
posibles letras son A, C, G, y T, que simbolizan las cuatro subunidades de nucleótidos de una banda ADN
(adenina, citosina, guanina, timina). En el típico caso, las secuencias se presentan pegadas unas a las
otras, sin espacios, como en la secuencia AAAGTCTGAC. En el caso del ARN, las secuencias están
formadas por las letras A, C, G, y U, que simbolizan los nucleótidos (adenina, citosina, guanina, uracilo).
En esta práctica se van a desarrollar un programa Gen.java con las funciones básicas para manejar
secuencias genéticas. Para ello hay que implementar una estructura de datos mediante una lista enlazada
en las que cada nodo contenga una letra de una (sub)secuencia genética. Es decir, una secuencia genética
completa estará formada por n nodos cada uno de ellos conteniendo una cadena de ADN o de ARN.

Para crear y manipular las secuencias genéticas se definen un conjunto de instrucciones en un fichero de
entrada, que será procesado por el programa, que al ejecutarse tomará como primer argumento el tamaño
del array, y como segundo el nombre del fichero. Por ejemplo:

```bash
java Gen.java 10 bio.in
```

En estos fichero pueden aparecer las siguientes instrucciones:

- ```insert pos tipo secuencia``` para insertar en la posición pos una secuencia genética de tipo ADN o ARN con la
secuencia dada. Se debe comprobar que la secuencia contiene solo letras adecuadas al tipo de secuencia
antes de realizar la operación. Si ya hubiera una secuencia en la posición pos, la nueva secuencia
reemplaza a la anterior. Si la secuencia a insertar no contiene ningún carácter, se insertará en esa posición
una secuencia vacía.

- ```remove pos``` para borrar la secuencia en la posición pos

- ```print``` para imprimir toda la secuencia genética indicando las secuencias y de que tipo son.

- ```print pos``` para imprimir solo la secuencia en la posición ```pos```.

- ```clip pos start end``` pra reemplazar la secuencia en la posición ```pos``` por la sub-secuencia que se obtiene con
todas las letras desde la letra en la posición ```start``` hasta la letra en posición ```end```. Si no se especifica ```end```, se considera hasta el final de la secuencia.

- ```copy pos1 pos2``` para copiar la secuencia de la posición ```pos1``` a la posición ```pos2```.

- ```swap pos1 start1 pos2 start2``` para intercambiar la cola de la secuencia en ```pos2``` a partir de la letra en la
posición ```start2```, hasta el final; por la cola de la secuencia desde en la posición ```pos1``` desde la letra ```start1``` hasta el final.

- ```transcribe pos``` para conviertir una secuencia de ADN en otra de ARN. Para realizar esta operación hay que
cambiar todas las T por U, y después cambiar todas las letras por su complementarias (es decir las A se
transforman en U y viceversa, las C se transforman en G y viceversa). Una vez terminada la operación se
invierte la secuencia. Por ejemplo la secuencia TGAC se transforma en UGAC, luego en ACUG y
finalmente se invierte dando como resultado GUCA.

Si cualquier instrucción tuviera algún error, (por ejemplo si ```start``` > ```end```, o si hubiera un número negativo,
o si no se encuentra la sub-secuencia), entonces esa instrucción no debe ejecutarse.

# Ejercicios de Collections y Algoritmos

Los primeros ejercicios se basan en rehacer algunos ya vistos con genéricos, para ver las diferencias y el ahorro de tiempo.

[1]. Use la clase Stack<E> de Java para invertir una palabra. A partir de este programa determine si una palabra es palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda: reconocer, rotor, somos,..)

[2]. Use el interfaz List<E> para guardar una lista de números. Los números se pasarán a través de los argumentos del programa (el args de main) y se transformarán en enteros con el método parseInt de la clase Integer, para luego añadirlos al final de la lista con el método add. Cuando ya no haya más números, imprima el número de elementos leídos (size).

Luego eleve todos al cuadrado (use get y set). Recorra la lista y suprima los número mayores de 100 (use iterator). Ahora ordénelos (use sort de la clase Collections). Una vez hecho esto, saque (use remove) de la lista los números, respetando su nuevo orden, e imprímalos.

[3]. Utilice la función indexOf de la clase Vector<E> para buscar un elemento en un array de elementos (no se sorprenda, es trivial)

[4]. Defina una lista List<E> con la clase Empleado antes definida (con nombre, apellidos, fecha de contratación y número de empleado). Use la función sort de la clase Collections para ordenar la lista. Use la antigüedad como criterio a seguir (es “mayor” si es más antiguo) y si entraron en el mismo día, utilice el número de empleado para desempatar.

Esta ordenación se reflejará en un método de la clase Empleado, compareTo(obj o), que permite comparar el objeto en curso (this) con el objeto recibido, que devuelve -1 si es menor que el recibido, 0 si son iguales y 1 si es mayor que el recibido.

[5]. Defina una lista List<E> con la clase que representa una entrada de una agenda, con el nombre, primer apellido, segundo apellido, teléfono, e-mail y móvil. Use la función sort para ordenarla. Use como criterio de ordenación los apellidos y luego el nombre.

[6]. Defina e implemente un directorio de teléfonos mediante un Map<K, V>. En el mismo tendrá entradas de agenda con los campos anteriores. Se buscará por el nombre y apellidos y devolverá la entrada de agenda correspondiente. Pruebe a insertar unas pocas entradas y luego a buscar alguna de ellas. Pruebe a insertar dos nombre iguales, que cambie simplemente en el orden de los apellidos.

[7]. Use otro directorio Map<K,V> para contar palabras iguales. Deberá buscar cada palabra y si ya está incrementar el contador asociado. Si no está deberá insertarla con el contador a 1.

[8]. Construya mediante una List<String> una lista que represente una baraja americana, con 4 palos (corazones, picas, diamantes y tréboles) y 12 cartas cada uno (as, 2, 3,…10, paje, reina, rey). Construya el array con dos bucles anidados. Barajela con el método shuffle de Collections. Construya una función repartir que dada una baraja devuelva una mano de “n”
cartas, empezando por el final del array (¡la baraja está boca abajo!), use sublistas (subList) y que suprime las cartas de la baraja (método clear), para evitar poder dar dos veces la misma carta. Emplee esta función para repartir “n” cartas a “m” jugadores, recibiendo tanto n como m a través de los argumentos del programa. Previamente debe barajar las cartas,
para asegurarse que nadie sabe que cartas se repartirán a cada uno.

[9]. A partir de un conjunto de palabras pasadas como argumento al programa (args) indique que palabras están repetidas y al final imprima cuantas palabras únicas había (sin contar repeticiones) e imprímalas. Utilice conjuntos (Set)

[10]. Dados dos conjuntos de palabras imprima las que están en un conjunto u otro pero no en los dos simultáneamente. Utilice la unión (addAll) y la intersección (retainAll)

[11]. Dada una lista de palabras que se pasan como argumento al programa (args) imprimalas ordenadas (sort de Collections) y luego según un orden aleatorio (shuffle de Collections)

[12]. Dada una lista de palabras que se pasan como argumento al programa (args) indique los anagramas que contiene. Anagramas son dos palabras que contienen las mismas letras pero en distintos orden (roma-amor, zorra-arroz, ladron-roldan). Para ello utilice un Map<K,V>. 

Como pista indicar que dos anagramas, al ordenarlos, quedan iguales. Para ordenar un String lo mejor es pasarlo a un array de caracteres (toCharArray) y luego ordenarlo con sort de Arrays.

[13]. Dado un número natural, pasado como argumento, se pide calcular los “números supervivientes”, que se obtienen de eliminar de la secuencia 1, 2, 3,…, n los números de dos en dos (el 1, 3, 5,…), luego se suprimen de tres en tres y así sucesivamente. El proceso termina cuando se va a eliminar los números de m en m pero ya que quedan menos de m
números.

[14]. Escriba un método que reciba una lista de objetos de clase figura (con subclases círculo, rectángulo, triángulo) y devuelva la suma de las áreas de todas las figuras.

[15]. Escriba una agenda electrónica que almacene reuniones clasificadas por días (día, mes y año) y dentro de un día por horas. No puede haber dos reuniones para una misma hora. Las reuniones deben estar ordenadas cronológicamente, se deben poder añadir nuevas reuniones así como quitar otras. También debemos poder preguntar por las reuniones programadas entre para un día, para un mes o para un rango dado por una fecha de inicio y otra de fin. Las reuniones tendrán, además de la fecha y hora, la sala donde tendrá lugar (String) y la persona con la que nos reuniremos, con nombre y apellidos. Para
implementarla se recomienda apoyarse en la interfaz SortedSet.

[16]. Escriba un programa que para un pedido dado calcule el importe por cada artículo y el importe total del pedido. El pedido consta de una lista de artículos, cada uno con su descripción (String), el número de unidades solicitadas y el precio de cada unidad. Se recomienda utilizar la interfaz List para implementarlo.

[17]. El agente 069 ha inventado un nuevo método de codificación de mensajes secretos. El mensaje original, X, se codifica en dos etapas. En primer lugar se reemplaza cada sucesión de caracteres consecutivos que no sean vocales por su inversa. En segundo lugar se genera la nueva versión tomando sucesivamente el primer carácter y luego el último, después el
segundo y el penúltimo y así sucesivamente. 

Por ejemplo:

- Original: Anacleto, agente secreto
- Paso 1: Analceto ,agentes erceto
- Paso 2: Aontaelccreet os e,natge

Diseñe los métodos de codificación y descodificación de los mensajes. Estos se reciben como args del main (entre comillas para respetar los blancos), se pueden pasar a una List<Char> con Arrays.asList y con toCharArray de String. Luego se puede usar una pila para invertir letras.

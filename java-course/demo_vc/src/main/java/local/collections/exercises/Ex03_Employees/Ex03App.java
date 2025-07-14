package local.collections.exercises.Ex03_Employees;
/* 
[4]. Defina una lista List<E> con la clase Empleado antes definida 
(con nombre, apellidos, fecha de contratación y número de empleado). 
Use la función sort de la clase Collections para ordenar la lista. 
Use la antigüedad como criterio a seguir (es “mayor” si es más antiguo) y 
si entraron en el mismo día, utilice el número de empleado para desempatar.

Esta ordenación se reflejará en un método de la clase Empleado, 
compareTo(obj o), que permite comparar el objeto en curso (this) con el objeto recibido, 
que devuelve -1 si es menor que el recibido, 
0 si son iguales y 1 si es mayor que el recibido.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex03App {

    static List<Employee> list = new ArrayList<>();

    static void sortList() {
        Collections.sort(list);

    }

    public static void main(String[] args) {

        list.add(new Employee(2, "Pepa", "Perez", "21/12/2023"));
        list.add(new Employee(1, "Pepe", "Perez", "21/12/2023"));
        list.add(new Employee(3, "Luisa", "Lopez", "12/12/2023"));

        sortList();
        System.err.println(list);

    }

}
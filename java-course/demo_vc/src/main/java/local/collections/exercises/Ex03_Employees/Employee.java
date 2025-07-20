package local.collections.exercises.Ex03_Employees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* 
Clase Empleado antes definida 
(con nombre, apellidos, fecha de contratación y número de empleado). 

Use la función sort de la clase Collections para ordenar la lista. 
Use la antigüedad como criterio a seguir (es “mayor” si es más antiguo) y 
si entraron en el mismo día, utilice el número de empleado para desempatar.

Esta ordenación se reflejará en un método de la clase Empleado, 
compareTo(obj o), que permite comparar el objeto en curso (this) con el objeto recibido, 
que devuelve -1 si es menor que el recibido, 
0 si son iguales y 1 si es mayor que el recibido.
*/

public class Employee implements Comparable<Employee> {
    int id;
    String name;
    String surname;
    LocalDate date;

    public Employee(int id, String name, String surname, String date) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = formatDate(date);
    }

    private LocalDate formatDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date;
    }

    private long calculaEmployDays() {
        LocalDate actualDate = LocalDate.now();
        // Period period = Period.between(date, actualDate);
        // years = period.get);
        // months = period.getMonths();
        // days = period.getDays();
        return ChronoUnit.DAYS.between(date, actualDate);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", date=" + date + "]";
    }

    @Override
    public int compareTo(Employee other) {
        int diffDays = (int) (other.calculaEmployDays() - this.calculaEmployDays());
        if (diffDays == 0) {
            return this.id - other.id;
        }
        return diffDays;
    }

}
package base;

public class Person {

  public static int personCount=0;

  public static void updateCounter() {
      personCount++;
  }

  public String name;
  public int age;

  public Person(String name, int age) {
    this.name = name;
    this.age  = age;
    System.out.println("Persona Instanciada ");
    updateCounter();//personCount++;
  }

  public void greetings() {
     System.out.printf("Hola soy %s y tengo %s años\n",name,age );
     System.out.printf("Contador de Personas = %s", personCount );
  }

  public void setAge(int age) {
      this.age = age;
  }
}

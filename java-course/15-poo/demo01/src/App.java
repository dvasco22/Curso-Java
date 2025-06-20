import base.Person;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
       
        Person p1 = new Person("Diego",54);
        //Person.personCount++;

        //p1.name="Diego";
        //p1.age=54;
        
        p1.greetings();
        p1.setAge(20);

    }
}

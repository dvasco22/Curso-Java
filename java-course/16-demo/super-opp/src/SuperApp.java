import containers.Bag;
import containers.Box;
import containers.IContainer;
import orders.IOrder;
import orders.Order;
import products.Drugstore;
import products.Food;
import products.Hygiene;
import products.IProduct;
import products.Pet;

public class SuperApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido a nuestro supermercado onLine");

        IOrder order1 = new Order("Pepe-001");

        IContainer box1 = new Box("B007", 50, 50, 50);
        IContainer bag1 = new Bag("B005", 50, 50, 5);

        System.out.println(box1);
        System.out.println(bag1);

        order1.addContainer(bag1);
        order1.addContainer(box1);
        System.out.println(order1);

        IProduct p1 = new Food("Patatas", 1500, 1000);
        IProduct p2 = new Drugstore("Detergente", 1000, 1000);
        IProduct p3 = new Hygiene("Papel Higiénico", 1000, 100);
        IProduct p4 = new Pet("Comida para perros", 1000, 2000);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        IContainer c1 = order1.addProduct(p1);
        IContainer c2 = order1.addProduct(p2);
        IContainer c3 = order1.addProduct(p3);
        IContainer c4 = order1.addProduct(p4);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}

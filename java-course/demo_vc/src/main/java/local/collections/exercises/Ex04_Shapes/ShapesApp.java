package local.collections.exercises.Ex04_Shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapesApp {

    List<Shape> shapes = new ArrayList<>();
    double totalArea;

    void addShape(Shape shape) {
        shapes.add(shape);
        // totalArea += shape.calculateArea();
    }

    void calculateTotalArea() {
        shapes.forEach(shape -> totalArea += shape.calculateArea());
    }

    void showTotalArea() {
        shapes.forEach(shape -> System.out.println(shape));
        System.out.println("El area total es %.2f%n".formatted(totalArea));
    }

    public static void main(String[] args) {
        ShapesApp shapes = new ShapesApp();
        shapes.addShape(new Circle(12));
        shapes.addShape(new Triangle(4, 7));
        shapes.addShape(new Rectangle(4, 8));
        shapes.calculateTotalArea();
        shapes.showTotalArea();
    }
}

package local.collections.exercises.Ex04_Shapes;

public class Triangle implements Shape {

    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height / 2.0;
    }

    @Override
    public String toString() {
        return "Triangle [base=" + base + ", height=" + height + "]";
    }

}
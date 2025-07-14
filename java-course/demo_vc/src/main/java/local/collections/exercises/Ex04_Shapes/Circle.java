package local.collections.exercises.Ex04_Shapes;

public class Circle implements Shape {
    double radio;

    public Circle(int radio) {
        this.radio = radio;
    }

    @Override
    public double calculateArea() {
        return radio * radio * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle [radio=" + radio + "]";
    }

}

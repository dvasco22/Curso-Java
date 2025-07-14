package local.collections.exercises.Ex04_Shapes;

public class Rectangle implements Shape {

    double hight;
    double length;

    public Rectangle(double hight, double length) {
        this.hight = hight;
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return hight * length;
    }

    @Override
    public String toString() {
        return "Rectangle [hight=" + hight + ", length=" + length + "]";
    }

}

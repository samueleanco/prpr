package ch.fhnw.ch.tutorials.grundkurs2;

public class Triangle implements Shape {
    double a;
    double b;
    double c;
    public Triangle (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String name() {
        return "Triangle";
    }

    @Override
    public double area() {
        return 0.25 * Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c));
    }

    @Override
    public double circumference() {
        return a + b + b;
    }

    public static void main (String[] args) {
        var Triangle = new Triangle(3,4,5);
        System.out.println(Triangle.area());

    }
}

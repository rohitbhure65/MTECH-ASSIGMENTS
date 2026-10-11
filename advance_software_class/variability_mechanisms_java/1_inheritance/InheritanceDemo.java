abstract class Shape {
    String name;

    Shape(String name) { this.name = name; }

    abstract double area();
    abstract double perimeter();

    void describe() {
        System.out.println("Shape     : " + name);
        System.out.printf("  Area     : %.2f%n", area());
        System.out.printf("  Perimeter: %.2f%n", perimeter());
    }
}

class Circle extends Shape {
    double radius;
    Circle(double r) { super("Circle"); this.radius = r; }

    @Override public double area()      { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    double width, height;
    Rectangle(double w, double h) { super("Rectangle"); width = w; height = h; }

    @Override public double area()      { return width * height; }
    @Override public double perimeter() { return 2 * (width + height); }
}

class Triangle extends Shape {
    double a, b, c;
    Triangle(double a, double b, double c) { super("Triangle"); this.a=a; this.b=b; this.c=c; }

    @Override public double area() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
    @Override public double perimeter() { return a + b + c; }

    boolean isEquilateral() { return a == b && b == c; }

    @Override void describe() {
        super.describe();
        System.out.println("  Equilateral: " + (isEquilateral() ? "Yes" : "No"));
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: INHERITANCE ===\n");

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4, 5),
            new Triangle(5, 5, 5)
        };

        for (Shape s : shapes) {
            s.describe();
            System.out.println("----------------------------");
        }
    }
}

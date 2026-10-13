class Shape {
    String color;
    Shape(String color) {
        this.color = color;
    }
    void displayColor() {
        System.out.println("Shape ka rang: " + color);
    }
    double area() {
        return 0.0;
    }
}
class Circle extends Shape {
    double radius;
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    void displayInfo() {
        System.out.println("Circle | Rang: " + color + " | Radius: " + radius);
        System.out.printf("Circle ka Area: %.2f sq units%n", area());
    }
}
class Rectangle extends Shape {
    double length, width;
    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width  = width;
    }
    @Override
    double area() {
        return length * width;
    }
    void displayInfo() {
        System.out.println("Rectangle | Rang: " + color + " | Length: " + length + " | Width: " + width);
        System.out.printf("Rectangle ka Area: %.2f sq units%n", area());
    }
}
class Triangle extends Shape {
    double base, height;
    Triangle(String color, double base, double height) {
        super(color);
        this.base   = base;
        this.height = height;
    }
    @Override
    double area() {
        return 0.5 * base * height;
    }
    void displayInfo() {
        System.out.println("Triangle | Rang: " + color + " | Base: " + base + " | Height: " + height);
        System.out.printf("Triangle ka Area: %.2f sq units%n", area());
    }
}
public class HierarchicalInheritance {
    public static void main(String[] args) {
        System.out.println("===== Hierarchical Inheritance Demo =====\n");
        Circle    c = new Circle("Laal", 7.0);
        Rectangle r = new Rectangle("Neela", 5.0, 3.0);
        Triangle  t = new Triangle("Hara", 6.0, 4.0);
        c.displayColor();
        c.displayInfo();
        System.out.println();
        r.displayColor();
        r.displayInfo();
        System.out.println();
        t.displayColor();
        t.displayInfo();
    }
}

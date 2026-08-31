import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first value: ");
        int a = sc.nextInt();

        System.out.print("Enter second value: ");
        int b = sc.nextInt();

        System.out.println("\n Arithmetic Operators");
        System.out.println("Sum: " + (a + b));
        System.out.println("Subtract: " + (a - b));
        System.out.println("Multiply: " + (a * b));
        System.out.println("Divide: " + (a / b));
        System.out.println("Remainder: " + (a % b));

        System.out.println("\n    Relational Operaors");
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));

        System.out.println("\n  Logical Operators ---");
        boolean x = true;
        boolean y = false;
        System.out.println("x AND y: " + (x && y));
        System.out.println("x OR y: " + (x || y));
        System.out.println("NOT x: " + (!x));

        System.out.println("\n--- Assignment Operators ---");
        int c = a;
        c += b;
        System.out.println("c = a, then c += b: " + c);

        System.out.println("\n--- Unary Operators ---");
        int d = a;
        System.out.println("d++: " + (d++));
        System.out.println("value of d " + d);

        sc.close();
    }
}

package Exception.src;

import java.lang.reflect.Method;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class Student {
    @SuppressWarnings("unused")
    private void display() {
        System.out.println("Hello student");
    }
}

public class App {

    static int divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Cannot devide by zero");
        return a / b;
    }

    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less then 18 invalid age");
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Student s = new Student();
            Method m = Student.class.getDeclaredMethod("display");

            m.invoke(s);

            System.out.println(divide(3, 3));
            checkAge(14);
        } catch (ArithmeticException e) {
            System.out.println("Error" + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("illigal access");
        } finally {
            System.out.println("Cleanup always run");
        }
    }
}

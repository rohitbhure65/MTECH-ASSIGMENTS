public class Combiner {
    
    // Generic function (similar to C++ template) for custom objects
    public static <T extends Addable<T>> T add(T a, T b) {
        return a.add(b);
    }

    // Method overloading for primitive and built-in types (since they don't implement Addable)
    public static int add(int a, int b) {
        return a + b;
    }

    public static String add(String a, String b) {
        return a + b;
    }

    public static char add(char a, char b) {
        return (char) (a + b);
    }
}

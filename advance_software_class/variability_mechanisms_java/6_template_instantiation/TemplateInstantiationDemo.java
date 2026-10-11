import java.util.*;

class TypedStack<T> {
    private List<T> stack = new ArrayList<>();
    private String  typeName;

    TypedStack(String typeName) { this.typeName = typeName; }

    void push(T item) {
        stack.add(item);
        System.out.println("  [" + typeName + " Stack] Push: " + item);
    }

    T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        T item = stack.remove(stack.size() - 1);
        System.out.println("  [" + typeName + " Stack] Pop : " + item);
        return item;
    }

    T peek() { return stack.isEmpty() ? null : stack.get(stack.size() - 1); }

    int size()      { return stack.size(); }
    boolean isEmpty(){ return stack.isEmpty(); }

    void display() {
        System.out.println("  [" + typeName + " Stack] Contents: " + stack);
    }
}

class Pair<A, B> {
    A first; B second;
    Pair(A first, B second) { this.first = first; this.second = second; }

    @Override public String toString() {
        return "Pair<" + first.getClass().getSimpleName()
             + ", " + second.getClass().getSimpleName()
             + ">(" + first + ", " + second + ")";
    }
}

class TypedMinFinder<T extends Comparable<T>> {
    T findMin(List<T> list) {
        return list.stream().min(Comparator.naturalOrder()).orElseThrow();
    }
}

public class TemplateInstantiationDemo {
    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: TEMPLATE INSTANTIATION ===\n");

        System.out.println("--- Template Instance 1: TypedStack<Integer> ---");
        TypedStack<Integer> intStack = new TypedStack<>("Integer");
        intStack.push(10); intStack.push(20); intStack.push(30);
        intStack.display();
        intStack.pop();
        intStack.display();

        System.out.println();

        System.out.println("--- Template Instance 2: TypedStack<String> ---");
        TypedStack<String> strStack = new TypedStack<>("String");
        strStack.push("Alpha"); strStack.push("Beta"); strStack.push("Gamma");
        strStack.display();
        strStack.pop();
        strStack.display();

        System.out.println();

        System.out.println("--- Template Instance 3: Pair<String, Integer> ---");
        Pair<String, Integer> p1 = new Pair<>("Rohit", 25);
        Pair<Double, Boolean> p2 = new Pair<>(3.14, true);
        System.out.println("  " + p1);
        System.out.println("  " + p2);

        System.out.println();

        System.out.println("--- Template Instance 4: TypedMinFinder<Integer> ---");
        TypedMinFinder<Integer> intFinder = new TypedMinFinder<>();
        List<Integer> nums = Arrays.asList(42, 7, 18, 3, 99);
        System.out.println("  List   : " + nums);
        System.out.println("  Min    : " + intFinder.findMin(nums));

        System.out.println();
        System.out.println("--- Template Instance 5: TypedMinFinder<String> ---");
        TypedMinFinder<String> strFinder = new TypedMinFinder<>();
        List<String> words = Arrays.asList("mango", "apple", "banana", "cherry");
        System.out.println("  List   : " + words);
        System.out.println("  Min    : " + strFinder.findMin(words));
    }
}

package MemoeryAndVariable;

public class MemoryDemo {
    static int classField = 10; // static/class variable — Method Area/Metaspace, ONE copy shared

    int instanceField = 20; // instance variable — Heap, one copy PER OBJECT

    void demo() {
        int localVar = 30; // local variable — Stack, exists only during method call
        // must be initialized before use — no default value like fields get

        System.out.print(localVar);

    }

    public static void main(String[] args) {
        MemoryDemo obj1 = new MemoryDemo(); // obj1 reference on Stack, object data on Heap
        MemoryDemo obj2 = new MemoryDemo();

        obj1.instanceField = 99;
        System.out.println(obj2.instanceField); // 20 — separate copy, unaffected

        classField = 77;
        System.out.println(MemoryDemo.classField); // 77 — shared by ALL instances

        // System.out.print(localVar); // error

    }
}

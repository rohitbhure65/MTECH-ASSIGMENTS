package string;

public class StringBufferDemo {
    public static void main(String[] args) {
        // StringBuffer is MUTABLE (can be changed).
        // It IS THREAD-SAFE (Synchronized methods).
        // Because of synchronization, it is slightly SLOWER than StringBuilder.
        // Use it in multi-threaded environments where multiple threads modify the same string.
        
        StringBuffer sb = new StringBuffer("Hello");
        
        System.out.println("--- StringBuffer Methods ---");
        System.out.println("Initial String: " + sb);
        
        // 1. Append
        sb.append(" World");
        System.out.println("1. After append: " + sb);
        
        // 2. Insert
        sb.insert(6, "Java ");
        System.out.println("2. After insert: " + sb);
        
        // 3. Replace
        sb.replace(6, 10, "Secure");
        System.out.println("3. After replace: " + sb);
        
        // 4. Delete
        sb.delete(5, 13);
        System.out.println("4. After delete: " + sb);
        
        // 5. Reverse
        sb.reverse();
        System.out.println("5. Reversed: " + sb);
        sb.reverse(); // put it back
        
        // 6. Capacity and Length
        System.out.println("6. Length: " + sb.length());
        System.out.println("   Capacity: " + sb.capacity());
        
        // 7. Ensure Capacity (Increases capacity explicitly to avoid multiple reallocation overheads)
        sb.ensureCapacity(100);
        System.out.println("   New Capacity: " + sb.capacity());
        
        // 8. Trim to size (Reduces capacity to exactly match the length to save memory)
        sb.trimToSize();
        System.out.println("   Trimmed Capacity (Matches Length): " + sb.capacity());
    }
}

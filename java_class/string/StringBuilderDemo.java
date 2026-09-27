package string;

public class StringBuilderDemo {
    public static void main(String[] args) {
        // StringBuilder is MUTABLE (can be changed).
        // It is NOT thread-safe, which makes it FASTER than StringBuffer.
        // It's the preferred choice for string manipulations in a single thread.
        
        StringBuilder sb = new StringBuilder("Hello");
        
        System.out.println("--- StringBuilder Methods ---");
        System.out.println("Initial String: " + sb);
        
        // 1. Append (Add to the end)
        sb.append(" World");
        System.out.println("1. After append: " + sb);
        
        // You can chain appends
        sb.append("!").append(" ").append(2024);
        System.out.println("   Chained appends: " + sb);
        
        // 2. Insert (Add at a specific index)
        sb.insert(5, " Java");
        System.out.println("2. After insert: " + sb);
        
        // 3. Replace (Start index, End index(exclusive), new string)
        sb.replace(6, 10, "Beautiful");
        System.out.println("3. After replace: " + sb);
        
        // 4. Delete (Start index, End index)
        sb.delete(5, 15); // Deletes " Beautiful"
        System.out.println("4. After delete: " + sb);
        
        // Delete a single character
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("   After deleteCharAt: " + sb);
        
        // 5. Reverse (Very commonly used in DSA - e.g., Palindrome check)
        sb.reverse();
        System.out.println("5. Reversed: " + sb);
        
        // Reverse back to normal
        sb.reverse();
        
        // 6. Capacity vs Length
        // Length is actual character count, Capacity is allocated memory size
        System.out.println("6. Length: " + sb.length());
        System.out.println("   Capacity: " + sb.capacity()); 
        
        // 7. Convert StringBuilder back to a standard String
        String finalString = sb.toString();
        System.out.println("7. Final Immutable String: " + finalString);
    }
}

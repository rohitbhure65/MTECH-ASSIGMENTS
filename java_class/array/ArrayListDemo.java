package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // ArrayList: Resizable array implementation of the List interface.
        // It grows dynamically as elements are added.
        
        // 1. Creating ArrayList
        List<Integer> list = new ArrayList<>();
        
        // 2. Adding elements (O(1) amortized)
        list.add(10);
        list.add(20);
        list.add(30);
        
        // 3. Adding at specific index (O(n) - elements shift right)
        list.add(1, 15);
        
        // 4. Accessing element (O(1))
        System.out.println("Element at index 2: " + list.get(2)); // Output: 20
        
        // 5. Modifying element
        list.set(0, 5); // Change index 0 to 5
        
        // 6. Removing element
        list.remove(Integer.valueOf(30)); // Remove by value
        list.remove(0); // Remove by index
        
        // 7. Checking size and if empty
        System.out.println("Size: " + list.size());
        System.out.println("Is empty? " + list.isEmpty());
        
        // 8. Checking if contains an element
        System.out.println("Contains 20? " + list.contains(20));
        
        // 9. Iterating over ArrayList
        System.out.println("ArrayList elements:");
        for (int num : list) {
            System.out.println(num);
        }
        
        // 10. Useful Utility: Sorting using Collections
        list.add(5);
        list.add(50);
        Collections.sort(list); // Sorts in ascending order
        System.out.println("Sorted list: " + list);
        
        // 11. Clearing list
        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}

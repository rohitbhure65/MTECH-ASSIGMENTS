package array;

public class BasicArrays {
    public static void main(String[] args) {
        // 1. Declaration and Initialization
        int[] arr1 = new int[5]; // Default values are 0
        int[] arr2 = {10, 20, 30, 40, 50}; // Direct initialization
        
        // 2. Accessing elements (0-indexed)
        System.out.println("First element: " + arr2[0]);
        System.out.println("Last element: " + arr2[arr2.length - 1]);
        
        // 3. Modifying elements
        arr2[1] = 25; // Changing 20 to 25
        
        // 4. Array Length property
        System.out.println("Length of arr2: " + arr2.length);
        
        // 5. Iterating (Standard For loop)
        System.out.print("Array elements: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        
        // 6. Iterating (Enhanced For-each loop - Cleaner syntax)
        System.out.print("Array elements (Enhanced): ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

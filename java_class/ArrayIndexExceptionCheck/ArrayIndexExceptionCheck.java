package ArrayIndexExceptionCheck;

import java.util.Scanner;

public class ArrayIndexExceptionCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        
        System.out.println("Please enter 10 numbers to store in the array:");
        
        try {
            // Prompt user for exactly 10 numbers
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                numbers[i] = scanner.nextInt();
            }
            
            System.out.println("\nAll 10 numbers stored successfully!");
            System.out.print("\nEnter an array index (0-9) to access the stored number: ");
            
            // Prompt user for an index, potentially throwing an exception
            int index = scanner.nextInt();
            System.out.println("Number at index " + index + " is: " + numbers[index]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("\nException Caught: ArrayIndexOutOfBoundsException!");
            System.err.println("You attempted to access an invalid index: " + e.getMessage() + ". Valid indices are 0 to 9.");
        } catch (Exception e) {
            System.err.println("\nException Caught: Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}

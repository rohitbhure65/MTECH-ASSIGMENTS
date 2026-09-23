package VowelExceptionCheck;

import java.util.Scanner;

// Custom Exception class
class NoVowelException extends Exception {
    public NoVowelException(String message) {
        super(message);
    }
}

public class VowelExceptionCheck {
    
    // Method to check for vowels in a string
    public static void checkForVowels(String str) throws NoVowelException {
        boolean hasVowel = false;
        String lowerStr = str.toLowerCase();
        
        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                hasVowel = true;
                break;
            }
        }
        
        // Throw the custom exception if no vowel is found
        if (!hasVowel) {
            throw new NoVowelException("The entered string does not contain any vowel characters.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        try {
            // Call the method to check the input
            checkForVowels(input);
            System.out.println("Success! The string contains at least one vowel.");
        } catch (NoVowelException e) {
            // Catch and handle the custom exception
            System.err.println("Exception Caught: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

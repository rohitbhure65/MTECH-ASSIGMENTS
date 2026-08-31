package number_utils;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Basic Coding Questions (Refactored) ===");
        
        System.out.println("\n--- 1. Armstrong Number ---");
        ArmstrongChecker armstrongChecker = new ArmstrongChecker();
        int armstrongTest = 153;
        int notArmstrongTest = 123;
        System.out.println(armstrongTest + " is Armstrong? " + armstrongChecker.check(armstrongTest));
        System.out.println(notArmstrongTest + " is Armstrong? " + armstrongChecker.check(notArmstrongTest));
        
        System.out.println("\n--- 2. Positive or Negative ---");
        SignChecker signChecker = new SignChecker();
        signChecker.check(15);
        signChecker.check(-42);
        signChecker.check(0);

        System.out.println("\n--- 3. Prime or Not Prime ---");
        PrimeChecker primeChecker = new PrimeChecker();
        int primeTest = 29;
        int notPrimeTest = 30;
        System.out.println(primeTest + " is Prime? " + primeChecker.check(primeTest));
        System.out.println(notPrimeTest + " is Prime? " + primeChecker.check(notPrimeTest));

        System.out.println("\n--- 4. Sum of Digits ---");
        DigitSumCalculator digitSumCalculator = new DigitSumCalculator();
        int sumTest = 12345;
        System.out.println("Sum of digits of " + sumTest + " is " + digitSumCalculator.calculate(sumTest));

        System.out.println("\n--- 5. Palindrome Number ---");
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        int palTest = 1221;
        int notPalTest = 1234;
        System.out.println(palTest + " is Palindrome? " + palindromeChecker.check(palTest));
        System.out.println(notPalTest + " is Palindrome? " + palindromeChecker.check(notPalTest));
    }
}

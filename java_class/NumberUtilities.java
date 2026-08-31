public class NumberUtilities {

    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        if (num < 0) return false;
        
        int digits = String.valueOf(num).length();
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return sum == original;
    }

    public static void checkPositiveNegative(int num) {
        if (num > 0) {
            System.out.println(num + " is Positive.");
        } else if (num < 0) {
            System.out.println(num + " is Negative.");
        } else {
            System.out.println(num + " is Zero.");
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        num = Math.abs(num);
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean isPalindrome(int num) {
        int original = num;
        if (num < 0) return false;
        int reverse = 0;
        
        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return original == reverse;
    }

    public static void main(String[] args) {
        System.out.println("=== Basic Coding Questions ===");
        
        System.out.println("\n--- 1. Armstrong Number ---");
        int armstrongTest = 153;
        int notArmstrongTest = 123;
        System.out.println(armstrongTest + " is Armstrong? " + isArmstrong(armstrongTest));
        System.out.println(notArmstrongTest + " is Armstrong? " + isArmstrong(notArmstrongTest));
        
        System.out.println("\n--- 2. Positive or Negative ---");
        checkPositiveNegative(15);
        checkPositiveNegative(-42);
        checkPositiveNegative(0);

        System.out.println("\n--- 3. Prime or Not Prime ---");
        int primeTest = 29;
        int notPrimeTest = 30;
        System.out.println(primeTest + " is Prime? " + isPrime(primeTest));
        System.out.println(notPrimeTest + " is Prime? " + isPrime(notPrimeTest));

        System.out.println("\n--- 4. Sum of Digits ---");
        int sumTest = 12345;
        System.out.println("Sum of digits of " + sumTest + " is " + sumOfDigits(sumTest));

        System.out.println("\n--- 5. Palindrome Number ---");
        int palTest = 1221;
        int notPalTest = 1234;
        System.out.println(palTest + " is Palindrome? " + isPalindrome(palTest));
        System.out.println(notPalTest + " is Palindrome? " + isPalindrome(notPalTest));
    }
}

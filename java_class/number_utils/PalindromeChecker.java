package number_utils;

public class PalindromeChecker {
    public boolean check(int num) {
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
}

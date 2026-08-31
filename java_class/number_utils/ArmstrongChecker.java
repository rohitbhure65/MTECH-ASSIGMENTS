package number_utils;

public class ArmstrongChecker {
    public boolean check(int num) {
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
}

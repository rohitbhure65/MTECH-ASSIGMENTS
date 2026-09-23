package DivisibilityCheck;

public class DivisibilityCheck {
    public static void main(String[] args) {
        // Check if no numbers or the wrong number of arguments are entered
        if (args.length != 2) {
            System.err.println("Error: No numbers or invalid number of arguments entered.");
            System.err.println("Usage: java DivisibilityCheck.DivisibilityCheck <num1> <num2>");
            return;
        }

        try {
            // Parse arguments from the command line
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            // Handle division by zero edge cases
            if (num1 == 0 && num2 == 0) {
                System.out.println("Both numbers are zero, division is undefined.");
            } else if (num1 == 0) {
                System.out.println(num1 + " is divisible by " + num2);
                System.out.println(num2 + " is not divisible by " + num1 + " (division by zero)");
            } else if (num2 == 0) {
                System.out.println(num1 + " is not divisible by " + num2 + " (division by zero)");
                System.out.println(num2 + " is divisible by " + num1);
            } else {
                // Check divisibility for non-zero integers
                boolean num1DivisibleByNum2 = (num1 % num2 == 0);
                boolean num2DivisibleByNum1 = (num2 % num1 == 0);

                if (num1DivisibleByNum2 && num2DivisibleByNum1) {
                    System.out.println("The numbers " + num1 + " and " + num2 + " are divisible by each other.");
                } else if (num1DivisibleByNum2) {
                    System.out.println(num1 + " is divisible by " + num2 + ", but " + num2 + " is not divisible by " + num1 + ".");
                } else if (num2DivisibleByNum1) {
                    System.out.println(num2 + " is divisible by " + num1 + ", but " + num1 + " is not divisible by " + num2 + ".");
                } else {
                    System.out.println("The numbers " + num1 + " and " + num2 + " are NOT divisible by each other.");
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("Error: Please provide valid integers as inputs.");
        }
    }
}

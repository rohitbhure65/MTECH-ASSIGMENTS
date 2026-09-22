package string.Q7_StringLength;

public class StringLength {
    public static void main(String[] args) {
        String str = "Hello World";
        int length = 0;
        // Using StringIndexOutOfBoundsException to find the length
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Reached the end of the string
        }
        System.out.println("String: " + str);
        System.out.println("Length of the string is: " + length);
    }
}

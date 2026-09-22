package string.Q4_CharFrequency;

public class CharFrequency {
    public static void main(String[] args) {
        String str = "hello world";
        char searchChar = 'l';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == searchChar) {
                count++;
            }
        }
        System.out.println("String: " + str);
        System.out.println("Character '" + searchChar + "' appears " + count + " times.");
    }
}

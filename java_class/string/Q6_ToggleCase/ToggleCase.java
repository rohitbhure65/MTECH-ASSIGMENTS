package string.Q6_ToggleCase;

public class ToggleCase {
    public static void main(String[] args) {
        String str = "Hello World!";
        StringBuilder toggled = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggled.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggled.append(Character.toUpperCase(ch));
            } else {
                toggled.append(ch);
            }
        }
        System.out.println("Original String: " + str);
        System.out.println("Toggled Case String: " + toggled.toString());
    }
}

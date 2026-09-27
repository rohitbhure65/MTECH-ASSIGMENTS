package string.Q1_ReverseString;

public class ReverseString {
    public static void main(String[] args) {
        String text = "hello world how are you";

        String[] words = text.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }
}

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

// public class Main {

//     public static String ReverseString(String text) {
//         String[] words = text.split(" ");
//         StringBuilder result = new StringBuilder();

//         for (int i = words.length - 1; i >= 0; i--) {
//             result.append(words[i]);

//             if (i > 0) {
//                 result.append(" ");
//             }
//         }

//         return result.toString();
//     }

//     public static void main(String[] args) {
//         String text = "hello world how are you";

//         String reversed = ReverseString(text);

//         System.out.println(reversed);
//     }
// }

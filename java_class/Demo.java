
class Demo {

    public static void reverseString(String str) {
        String words[] = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");

        }
    }

    public static void main(String[] args) {
        String str = "Hello world how are you";
        reverseString(str);

    }
}

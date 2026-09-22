package string.Q8_MaxOccurringChar;

public class MaxOccurringChar {
    public static void main(String[] args) {
        String str = "hello world";
        int[] freq = new int[256]; // Assuming ASCII characters
        
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        int maxFreq = -1;
        char maxChar = ' ';
        
        for (int i = 0; i < str.length(); i++) {
            if (maxFreq < freq[str.charAt(i)]) {
                maxFreq = freq[str.charAt(i)];
                maxChar = str.charAt(i);
            }
        }
        
        System.out.println("String: " + str);
        System.out.println("Maximum occurring character is: '" + maxChar + "' (appears " + maxFreq + " times)");
    }
}

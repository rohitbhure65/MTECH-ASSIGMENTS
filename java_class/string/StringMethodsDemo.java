package string;

public class StringMethodsDemo {
    public static void main(String[] args) {
        // Strings in Java are IMMUTABLE (cannot be changed once created)
        String str1 = "Hello, Java World!";
        String str2 = "hello, java world!";
        String str3 = new String("Hello"); // Creating using new keyword
        
        System.out.println("--- Basic String Methods ---");
        
        // 1. Length of string
        System.out.println("1. Length: " + str1.length());
        
        // 2. Character at a specific index
        System.out.println("2. Char at index 1: " + str1.charAt(1));
        
        // 3. Substring (Extracting parts of string)
        System.out.println("3. Substring from index 7: " + str1.substring(7));
        System.out.println("   Substring from 7 to 11: " + str1.substring(7, 11)); // endIndex is exclusive
        
        // 4. Comparison
        System.out.println("4. Equals exact? " + str1.equals(str2));
        System.out.println("   Equals ignore case? " + str1.equalsIgnoreCase(str2));
        System.out.println("   Compare lexicographically: " + "apple".compareTo("banana")); // Returns negative
        
        // 5. Case conversion
        System.out.println("5. Uppercase: " + str1.toUpperCase());
        System.out.println("   Lowercase: " + str1.toLowerCase());
        
        // 6. Searching
        System.out.println("6. Index of 'Java': " + str1.indexOf("Java"));
        System.out.println("   Last index of 'o': " + str1.lastIndexOf('o'));
        System.out.println("   Contains 'World'? " + str1.contains("World"));
        System.out.println("   Starts with 'Hello'? " + str1.startsWith("Hello"));
        System.out.println("   Ends with '!'? " + str1.endsWith("!"));
        
        // 7. Replacement (Returns a NEW string, original is unmodified)
        System.out.println("7. Replace 'Java' with 'Python': " + str1.replace("Java", "Python"));
        
        // 8. Trimming (Removes leading/trailing whitespaces)
        String messyString = "   Spaces   ";
        System.out.println("8. Trimmed: '" + messyString.trim() + "'");
        
        // 9. Splitting (Useful for parsing)
        String csv = "apple,banana,grape";
        String[] fruits = csv.split(",");
        System.out.println("9. Split output: ");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }
        
        // 10. String to Char Array (Useful for DSA)
        char[] chars = str1.toCharArray();
        System.out.println("10. First char from charArray: " + chars[0]);
        
        // 11. String formatting
        String formatted = String.format("My name is %s and I am %d years old", "John", 25);
        System.out.println("11. Formatted string: " + formatted);
    }
}

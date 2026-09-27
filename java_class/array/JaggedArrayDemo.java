package array;

public class JaggedArrayDemo {
    public static void main(String[] args) {
        // Jagged Array: An array of arrays where member arrays can be of different lengths.
        
        // 1. Declaration (Specifying number of rows only)
        int[][] jaggedArray = new int[3][];
        
        // 2. Initializing each row with a different number of columns
        jaggedArray[0] = new int[3]; // Row 0 has 3 columns
        jaggedArray[1] = new int[2]; // Row 1 has 2 columns
        jaggedArray[2] = new int[4]; // Row 2 has 4 columns
        
        // 3. Populating the jagged array
        int count = 1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = count++;
            }
        }
        
        // 4. Displaying the jagged array
        System.out.println("Jagged Array Output:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println(); // Move to next line for the next row
        }
        
        // 5. Array of Strings example
        String[][] stringJagged = {
            {"Java", "C++"},
            {"Python", "JavaScript", "TypeScript"},
            {"Go"}
        };
        
        System.out.println("\nString Jagged Array:");
        for (String[] row : stringJagged) {
            for (String str : row) {
                System.out.print(str + " | ");
            }
            System.out.println();
        }
    }
}

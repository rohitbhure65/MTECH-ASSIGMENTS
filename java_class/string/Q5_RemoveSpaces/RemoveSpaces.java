package string.Q5_RemoveSpaces;

public class RemoveSpaces {
    public static void main(String[] args) {
        String str = "H e l l o   W o r l d";
        String noSpaceStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                noSpaceStr += str.charAt(i);
            }
        }
        System.out.println("Original String: " + str);
        System.out.println("String without spaces: " + noSpaceStr);
    }
}

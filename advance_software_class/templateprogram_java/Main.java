import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.println("Numbers sum: " + Combiner.add(num1, num2) + "\n");

        scanner.nextLine(); // consume newline

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        System.out.println("String concatenation: " + Combiner.add(str1, str2) + "\n");

        System.out.print("Enter a character: ");
        char c1 = scanner.next().charAt(0);
        System.out.print("Enter an integer to add to the character: ");
        int temp_c2 = scanner.nextInt();
        char c2 = (char) temp_c2;
        System.out.println("Char addition ('" + c1 + "' + " + temp_c2 + "): " + Combiner.add(c1, c2) + "\n");

        scanner.nextLine(); // consume newline

        System.out.print("Enter path/name for File 1: ");
        String fileName1 = scanner.nextLine();
        System.out.print("Enter path/name for File 2: ");
        String fileName2 = scanner.nextLine();

        String fileContent1 = "";
        try {
            fileContent1 = new String(Files.readAllBytes(Paths.get(fileName1)));
        } catch (IOException e) {
            System.out.println("Could not open File 1. Using empty content.");
        }

        String fileContent2 = "";
        try {
            fileContent2 = new String(Files.readAllBytes(Paths.get(fileName2)));
        } catch (IOException e) {
            System.out.println("Could not open File 2. Using empty content.");
        }

        MyFile file1 = new MyFile(fileContent1);
        MyFile file2 = new MyFile(fileContent2);
        MyFile combinedFile = Combiner.add(file1, file2);
        System.out.println("Combined Files Content:\n" + combinedFile.content + "\n");

        System.out.print("Enter text for Paragraph 1: ");
        String para1 = scanner.nextLine();
        System.out.print("Enter text for Paragraph 2: ");
        String para2 = scanner.nextLine();
        Paragraph p1 = new Paragraph(para1);
        Paragraph p2 = new Paragraph(para2);
        Paragraph combinedParagraph = Combiner.add(p1, p2);
        System.out.println("Combined Paragraphs:\n" + combinedParagraph.text + "\n");

        System.out.print("Enter source path for Image 1: ");
        String imgPath1 = scanner.nextLine();
        System.out.print("Enter source path for Image 2: ");
        String imgPath2 = scanner.nextLine();
        Image image1 = new Image(imgPath1);
        Image image2 = new Image(imgPath2);
        Image combinedImage = Combiner.add(image1, image2);
        System.out.println("Combined Image Sources:\n" + combinedImage.imageData + "\n");

        scanner.close();
    }
}

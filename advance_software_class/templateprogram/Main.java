import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

// Interface to allow generic addition for custom classes (simulating C++ templates)
interface Addable<T> {
    T add(T other);
}

class MyFile implements Addable<MyFile> {
    public String content;

    public MyFile(String c) {
        this.content = c;
    }

    @Override
    public MyFile add(MyFile other) {
        return new MyFile(this.content + "\n" + other.content);
    }
}

class Paragraph implements Addable<Paragraph> {
    public String text;

    public Paragraph(String t) {
        this.text = t;
    }

    @Override
    public Paragraph add(Paragraph other) {
        return new Paragraph(this.text + "\n" + other.text);
    }
}

class Image implements Addable<Image> {
    public String imageData;

    public Image(String data) {
        this.imageData = data;
    }

    @Override
    public Image add(Image other) {
        return new Image(this.imageData + " [COMBINED WITH] " + other.imageData);
    }
}

public class Main {
    
    // Generic function (similar to C++ template) for custom objects
    public static <T extends Addable<T>> T add(T a, T b) {
        return a.add(b);
    }

    // Method overloading for primitive and built-in types (since they don't implement Addable)
    public static int add(int a, int b) {
        return a + b;
    }

    public static String add(String a, String b) {
        return a + b;
    }

    public static char add(char a, char b) {
        return (char) (a + b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.println("Numbers sum: " + add(num1, num2) + "\n");

        scanner.nextLine(); // consume newline

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        System.out.println("String concatenation: " + add(str1, str2) + "\n");

        System.out.print("Enter a character: ");
        char c1 = scanner.next().charAt(0);
        System.out.print("Enter an integer to add to the character: ");
        int temp_c2 = scanner.nextInt();
        char c2 = (char) temp_c2;
        System.out.println("Char addition ('" + c1 + "' + " + temp_c2 + "): " + add(c1, c2) + "\n");

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
        MyFile combinedFile = add(file1, file2);
        System.out.println("Combined Files Content:\n" + combinedFile.content + "\n");

        System.out.print("Enter text for Paragraph 1: ");
        String para1 = scanner.nextLine();
        System.out.print("Enter text for Paragraph 2: ");
        String para2 = scanner.nextLine();
        Paragraph p1 = new Paragraph(para1);
        Paragraph p2 = new Paragraph(para2);
        Paragraph combinedParagraph = add(p1, p2);
        System.out.println("Combined Paragraphs:\n" + combinedParagraph.text + "\n");

        System.out.print("Enter source path for Image 1: ");
        String imgPath1 = scanner.nextLine();
        System.out.print("Enter source path for Image 2: ");
        String imgPath2 = scanner.nextLine();
        Image image1 = new Image(imgPath1);
        Image image2 = new Image(imgPath2);
        Image combinedImage = add(image1, image2);
        System.out.println("Combined Image Sources:\n" + combinedImage.imageData + "\n");

        scanner.close();
    }
}

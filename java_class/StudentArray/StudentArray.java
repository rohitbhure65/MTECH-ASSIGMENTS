package StudentArray;

import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private String course;

    // Appropriate constructor
    public Student() {
        this.rollNumber = 0;
        this.name = "";
        this.course = "";
    }

    public Student(int rollNumber, String name, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
    }

    // Method for inputting student details
    public void inputDetails(Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        this.rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter Course: ");
        this.course = scanner.nextLine();
    }

    // Method for displaying student details
    public void displayDetails() {
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Name: " + this.name);
        System.out.println("Course: " + this.course);
        System.out.println("---------------------------");
    }
}

public class StudentArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create an array of five Student objects
        Student[] students = new Student[5];
        
        System.out.println("Enter details for 5 students:");
        // Use a loop to instantiate and call the input method
        for (int i = 0; i < 5; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            students[i] = new Student(); // Initialize each object in the array
            students[i].inputDetails(scanner);
        }
        
        System.out.println("\n=== Student Details ===");
        // Use a loop to call the display method
        for (int i = 0; i < 5; i++) {
            System.out.println("Details of Student " + (i + 1) + ":");
            students[i].displayDetails();
        }
        
        scanner.close();
    }
}

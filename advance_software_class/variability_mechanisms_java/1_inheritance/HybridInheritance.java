interface Workable {
    void work();
    void showDetails();
}
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }
    void eat() {
        System.out.println(name + " khaana kha raha/rahi hai.");
    }
    void sleep() {
        System.out.println(name + " so raha/rahi hai.");
    }
}
class Employee extends Person implements Workable {
    int employeeId;
    double salary;
    Employee(String name, int age, int employeeId, double salary) {
        super(name, age);
        this.employeeId = employeeId;
        this.salary     = salary;
    }
    @Override
    public void work() {
        System.out.println(name + " (Employee) office mein kaam kar raha/rahi hai.");
    }
    @Override
    public void showDetails() {
        System.out.println("Employee => Naam: " + name + " | Age: " + age +
                           " | EmpID: " + employeeId + " | Salary: " + salary);
    }
}
class Teacher extends Person implements Workable {
    String subject;
    String school;
    Teacher(String name, int age, String subject, String school) {
        super(name, age);
        this.subject = subject;
        this.school  = school;
    }
    @Override
    public void work() {
        System.out.println(name + " (Teacher) " + subject + " padhaa raha/rahi hai.");
    }
    @Override
    public void showDetails() {
        System.out.println("Teacher => Naam: " + name + " | Age: " + age +
                           " | Subject: " + subject + " | School: " + school);
    }
    void conductExam() {
        System.out.println(name + " exam le raha/rahi hai.");
    }
}
interface TeacherEmployeeRole extends Workable {
    void adminDuty();
}
class TeachingStaff extends Person implements TeacherEmployeeRole {
    String subject;
    int staffId;
    TeachingStaff(String name, int age, String subject, int staffId) {
        super(name, age);
        this.subject = subject;
        this.staffId = staffId;
    }
    @Override
    public void work() {
        System.out.println(name + " (TeachingStaff) padhaayi aur admin dono kaam karta/karti hai.");
    }
    @Override
    public void showDetails() {
        System.out.println("TeachingStaff => Naam: " + name + " | Age: " + age +
                           " | Subject: " + subject + " | StaffID: " + staffId);
    }
    @Override
    public void adminDuty() {
        System.out.println(name + " aaj admin duty par hai.");
    }
}
public class HybridInheritance {
    public static void main(String[] args) {
        System.out.println("===== Hybrid Inheritance Demo =====\n");
        Employee emp = new Employee("Rahul", 30, 1001, 75000.0);
        System.out.println("--- Employee ---");
        emp.eat();
        emp.work();
        emp.showDetails();
        System.out.println();
        Teacher teacher = new Teacher("Priya", 35, "Mathematics", "DPS Delhi");
        System.out.println("--- Teacher ---");
        teacher.sleep();
        teacher.work();
        teacher.conductExam();
        teacher.showDetails();
        System.out.println();
        TeachingStaff ts = new TeachingStaff("Amit", 40, "Physics", 2045);
        System.out.println("--- TeachingStaff (Hybrid) ---");
        ts.eat();
        ts.work();
        ts.adminDuty();
        ts.showDetails();
        System.out.println("\n--- Polymorphism via Workable Interface ---");
        Workable[] workers = {emp, teacher, ts};
        for (Workable w : workers) {
            w.work();
        }
    }
}

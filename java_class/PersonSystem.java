class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Employee2 extends Person {
    private String employeeId;
    private String jobTitle;

    public Employee2(String firstName, String lastName, String employeeId, String jobTitle) {
        super(firstName, lastName);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String getLastName() {
        return super.getLastName() + " (" + jobTitle + ")";
    }
}

public class PersonSystem {
    public static void main(String[] args) {
        System.out.println("=== Person System ===");
        
        Person person = new Person("Alice", "Smith");
        System.out.println("Person Name: " + person.getFirstName() + " " + person.getLastName());
        
        System.out.println();
        
        Employee2 employee = new Employee2("Bob", "Johnson", "E-7890", "Senior Developer");
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
    }
}

class Employee {
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public void work() {
        System.out.println("Employee is working on general tasks.");
    }

    public double getSalary() {
        return salary;
    }
}

class HRManager extends Employee {

    public HRManager(double salary) {
        super(salary);
    }

    @Override
    public void work() {
        System.out.println("HR Manager is managing human resources and recruitment.");
    }

    @Override
    public double getSalary() {
        return super.getSalary() + 10000; 
    }

    public void addEmployee() {
        System.out.println("HR Manager has added a new employee to the system.");
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee employee = new Employee(40000);
        System.out.println("--- Standard Employee ---");
        employee.work();
        System.out.println("Salary: $" + employee.getSalary());

        System.out.println();

        HRManager hrManager = new HRManager(65000);
        System.out.println("--- HR Manager ---");
        hrManager.work();
        System.out.println("Salary (including bonus): $" + hrManager.getSalary());
        hrManager.addEmployee();
    }
}

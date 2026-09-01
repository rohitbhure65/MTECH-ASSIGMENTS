
import java.util.ArrayList;
import java.util.List;

public class AdmissionProcess {
    private int academicYear;
    private Program program;
    private int seatCapacity;
    private MeritCalculator meritCalculator;
    private List<Student> applicants;
    private List<Student> admittedStudents;

    public AdmissionProcess(int academicYear, Program program, Department department, int seatCapacity, MeritCalculator meritCalculator) {
        this.academicYear = academicYear;
        this.program = program;
        this.seatCapacity = seatCapacity;
        this.meritCalculator = meritCalculator;
        this.applicants = new ArrayList<>();
        this.admittedStudents = new ArrayList<>();
    }

    public void apply(Student student) {
        applicants.add(student);
    }

    public void generateMeritListAndAdmit() {
        applicants.sort((s1, s2) -> Double.compare(meritCalculator.calculateMerit(s2), meritCalculator.calculateMerit(s1)));

        System.out.println("--- Merit List for " + program.getName() + " (" + academicYear + ") ---");
        int count = 0;
        for (Student s : applicants) {
            double score = meritCalculator.calculateMerit(s);
            System.out.println(s.getName() + " - Score: " + score);
            if (count < seatCapacity) {
                admittedStudents.add(s);
                count++;
            }
        }
        System.out.println("-------------------------------------------------");
    }

    public void printAdmittedStudents() {
        System.out.println("Admitted Students to " + program.getName() + " (" + academicYear + "):");
        for (Student s : admittedStudents) {
            System.out.println("- " + s.getName());
        }
    }

    public int getAcademicYear() { return academicYear; }
}

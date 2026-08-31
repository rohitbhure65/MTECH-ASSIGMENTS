package corporate_programs;

public class AcademicRecord {
    private EligibilityType degree;
    private double cgpa;
    private int graduationYear;

    public AcademicRecord(EligibilityType degree, double cgpa, int graduationYear) {
        this.degree = degree;
        this.cgpa = cgpa;
        this.graduationYear = graduationYear;
    }
    
    public double getCgpa() { return cgpa; }
    public EligibilityType getDegree() { return degree; }
}

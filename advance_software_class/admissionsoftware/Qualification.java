package admissionsoftware;

public class Qualification {
    private String degreeName;
    private double cgpaOrPercentage;
    private String institution;
    private int yearOfPassing;
    private QualificationType type;
    private boolean isSpecialExamQualified;
    private double specialExamScore;

    public Qualification(String degreeName, double cgpaOrPercentage, String institution, int yearOfPassing, QualificationType type) {
        this.degreeName = degreeName;
        this.cgpaOrPercentage = cgpaOrPercentage;
        this.institution = institution;
        this.yearOfPassing = yearOfPassing;
        this.type = type;
        this.isSpecialExamQualified = false;
    }

    public Qualification(String degreeName, double cgpaOrPercentage, String institution, int yearOfPassing, QualificationType type, boolean isSpecialExamQualified, double specialExamScore) {
        this(degreeName, cgpaOrPercentage, institution, yearOfPassing, type);
        this.isSpecialExamQualified = isSpecialExamQualified;
        this.specialExamScore = specialExamScore;
    }

    public double getCgpaOrPercentage() { return cgpaOrPercentage; }
    public boolean isSpecialExamQualified() { return isSpecialExamQualified; }
    public double getSpecialExamScore() { return specialExamScore; }
}

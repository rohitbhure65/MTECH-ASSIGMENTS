
public class StandardMeritCalculator implements MeritCalculator {
    private QualificationType baseQualification;

    public StandardMeritCalculator(QualificationType baseQualification) {
        this.baseQualification = baseQualification;
    }

    @Override
    public double calculateMerit(Student student) {
        Qualification q = student.getQualification(baseQualification);
        if (q == null) return 0.0;
        
        double score = q.getCgpaOrPercentage();
        if (score <= 10.0) {
            score = score * 9.5; // Standard CGPA to percentage conversion
        }
        return score;
    }
}

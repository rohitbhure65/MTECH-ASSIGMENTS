
public class GatePreferenceMeritCalculator implements MeritCalculator {
    @Override
    public double calculateMerit(Student student) {
        Qualification bachelors = student.getQualification(QualificationType.BACHELORS);
        if (bachelors == null) return 0.0;
        
        double baseScore = bachelors.getCgpaOrPercentage();
        if (baseScore <= 10.0) {
            baseScore = baseScore * 9.5; // Convert CGPA to percentage
        }
        
        Qualification gate = student.getQualification(QualificationType.GATE);
        
        if (gate != null && gate.isSpecialExamQualified()) {
            return (baseScore * 0.6) + (gate.getSpecialExamScore() * 0.4);
        }
        return baseScore * 0.6;
    }
}

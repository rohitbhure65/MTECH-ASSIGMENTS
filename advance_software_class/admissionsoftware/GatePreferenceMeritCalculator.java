
public class GatePreferenceMeritCalculator implements MeritCalculator {
    @Override
    public double calculateMerit(Student student) {
        Qualification q = student.getHighestQualification();
        double baseScore = q.getCgpaOrPercentage();
        if (baseScore <= 10.0) {
            baseScore = baseScore * 10;
        }
        if (q.isSpecialExamQualified()) {
            return (baseScore * 0.6) + (q.getSpecialExamScore() * 0.4);
        }
        return baseScore * 0.6;
    }
}

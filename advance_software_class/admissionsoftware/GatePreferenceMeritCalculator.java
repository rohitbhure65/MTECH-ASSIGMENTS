package admissionsoftware;

public class GatePreferenceMeritCalculator implements MeritCalculator {
    @Override
    public double calculateMerit(Student student) {
        Qualification q = student.getHighestQualification();
        double baseScore = q.getCgpaOrPercentage();
        if (q.isSpecialExamQualified()) {
            return (baseScore * 0.8) + (q.getSpecialExamScore() * 0.2);
        }
        return baseScore * 0.8;
    }
}

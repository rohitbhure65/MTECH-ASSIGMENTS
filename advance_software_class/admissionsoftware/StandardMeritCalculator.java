
public class StandardMeritCalculator implements MeritCalculator {
    @Override
    public double calculateMerit(Student student) {
        double score = student.getHighestQualification().getCgpaOrPercentage();
        if (score <= 10.0) {
            score = score * 10;
        }
        return score;
    }
}

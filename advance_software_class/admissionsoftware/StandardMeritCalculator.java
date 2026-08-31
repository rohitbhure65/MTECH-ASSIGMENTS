package admissionsoftware;

public class StandardMeritCalculator implements MeritCalculator {
    @Override
    public double calculateMerit(Student student) {
        return student.getHighestQualification().getCgpaOrPercentage();
    }
}

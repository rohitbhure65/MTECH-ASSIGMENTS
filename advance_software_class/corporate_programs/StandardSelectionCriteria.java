package corporate_programs;

import java.util.List;

public class StandardSelectionCriteria implements SelectionCriteria {
    private double minCgpa;
    private List<EligibilityType> allowedDegrees;

    public StandardSelectionCriteria(double minCgpa, List<EligibilityType> allowedDegrees) {
        this.minCgpa = minCgpa;
        this.allowedDegrees = allowedDegrees;
    }

    @Override
    public boolean isEligible(Candidate candidate) {
        AcademicRecord rec = candidate.getRecord();
        return rec.getCgpa() >= minCgpa && allowedDegrees.contains(rec.getDegree());
    }

    @Override
    public double calculateScore(Candidate candidate) {
        return candidate.getRecord().getCgpa();
    }
}

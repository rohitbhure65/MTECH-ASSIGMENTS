package corporate_programs;

public interface SelectionCriteria {
    boolean isEligible(Candidate candidate);
    double calculateScore(Candidate candidate);
}

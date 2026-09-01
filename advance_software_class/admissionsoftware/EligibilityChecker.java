public interface EligibilityChecker {
    boolean isEligible(Student student);
    String getRejectionReason(Student student);
}

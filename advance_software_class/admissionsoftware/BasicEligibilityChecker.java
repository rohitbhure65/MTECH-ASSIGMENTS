public class BasicEligibilityChecker implements EligibilityChecker {
    private QualificationType requiredType;
    private double minPercentage;

    public BasicEligibilityChecker(QualificationType requiredType, double minPercentage) {
        this.requiredType = requiredType;
        this.minPercentage = minPercentage;
    }

    @Override
    public boolean isEligible(Student student) {
        Qualification q = student.getQualification(requiredType);
        if (q == null) return false;
        
        double score = q.getCgpaOrPercentage();
        if (score <= 10.0) {
            score = score * 9.5;
        }
        return score >= minPercentage;
    }

    @Override
    public String getRejectionReason(Student student) {
        Qualification q = student.getQualification(requiredType);
        if (q == null) return "Missing required qualification: " + requiredType;
        
        double score = q.getCgpaOrPercentage();
        if (score <= 10.0) {
            score = score * 9.5;
        }
        if (score < minPercentage) {
            return String.format("Minimum percentage not met. Required: %.2f%%, Found: %.2f%%", minPercentage, score);
        }
        return "Eligible";
    }
}


public class Program {
    private String name;
    private ProgramType type;
    private Curriculum curriculum;
    private EligibilityChecker eligibilityChecker;

    public Program(String name, ProgramType type, Curriculum curriculum, EligibilityChecker eligibilityChecker) {
        this.name = name;
        this.type = type;
        this.curriculum = curriculum;
        this.eligibilityChecker = eligibilityChecker;
    }

    public String getName() { return name; }
    public ProgramType getType() { return type; }
    public Curriculum getCurriculum() { return curriculum; }
    public EligibilityChecker getEligibilityChecker() { return eligibilityChecker; }
}

package admissionsoftware;

public class Program {
    private String name;
    private ProgramType type;
    private Curriculum curriculum;

    public Program(String name, ProgramType type, Curriculum curriculum) {
        this.name = name;
        this.type = type;
        this.curriculum = curriculum;
    }

    public String getName() { return name; }
    public ProgramType getType() { return type; }
}

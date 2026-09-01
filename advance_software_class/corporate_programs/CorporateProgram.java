package corporate_programs;

public class CorporateProgram {
    private String programName;
    private ProgramCategory category;
    private int durationMonths;

    public CorporateProgram(String programName, ProgramCategory category, int durationMonths) {
        this.programName = programName;
        this.category = category;
        this.durationMonths = durationMonths;
    }
    
    public String getProgramName() { return programName; }
    public ProgramCategory getCategory() { return category; }
    public int getDurationMonths() { return durationMonths; }
}

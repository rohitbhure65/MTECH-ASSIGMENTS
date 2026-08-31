package corporate_programs;

public class Candidate {
    private String name;
    private String email;
    private AcademicRecord record;

    public Candidate(String name, String email, AcademicRecord record) {
        this.name = name;
        this.email = email;
        this.record = record;
    }
    
    public String getName() { return name; }
    public AcademicRecord getRecord() { return record; }
}

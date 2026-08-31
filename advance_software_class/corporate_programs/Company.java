package corporate_programs;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<CorporateProgram> offeredPrograms;

    public Company(String name) {
        this.name = name;
        this.offeredPrograms = new ArrayList<>();
    }
    
    public void addProgram(CorporateProgram program) {
        offeredPrograms.add(program);
    }
    
    public String getName() { return name; }
}


import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Program> offeredPrograms;

    public Department(String name) {
        this.name = name;
        this.offeredPrograms = new ArrayList<>();
    }

    public void addProgram(Program program) {
        offeredPrograms.add(program);
    }

    public String getName() { return name; }
}

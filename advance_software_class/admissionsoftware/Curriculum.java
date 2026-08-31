package admissionsoftware;

import java.util.List;

public class Curriculum {
    private int totalSemesters;
    private int totalCredits;
    private List<String> subjects;

    public Curriculum(int totalSemesters, int totalCredits, List<String> subjects) {
        this.totalSemesters = totalSemesters;
        this.totalCredits = totalCredits;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Curriculum{sems=" + totalSemesters + ", credits=" + totalCredits + ", subjects=" + subjects + '}';
    }
}

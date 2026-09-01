import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Qualification> qualifications;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.qualifications = new ArrayList<>();
    }

    public void addQualification(Qualification q) {
        this.qualifications.add(q);
    }

    public Qualification getQualification(QualificationType type) {
        return qualifications.stream()
                .filter(q -> q.getType() == type)
                .findFirst()
                .orElse(null);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Qualification> getQualifications() { return qualifications; }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}

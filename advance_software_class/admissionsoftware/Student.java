
public class Student {
    private String id;
    private String name;
    private Qualification highestQualification;

    public Student(String id, String name, Qualification highestQualification) {
        this.id = id;
        this.name = name;
        this.highestQualification = highestQualification;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Qualification getHighestQualification() { return highestQualification; }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}

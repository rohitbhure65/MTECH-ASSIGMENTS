package admissionsoftware;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generalized Student Admission & Program Registration System ===");

        Department csDept = new Department("Computer Science");
        Department mechDept = new Department("Mechanical Engineering");

        Curriculum btechCsCurriculum = new Curriculum(8, 160, Arrays.asList("Data Structures", "Algorithms", "OS"));
        Curriculum mtechCsCurriculum = new Curriculum(4, 80, Arrays.asList("Advanced ML", "Distributed Systems"));

        Program btechCS = new Program("B.Tech Computer Science", ProgramType.UG, btechCsCurriculum);
        Program mtechCS = new Program("M.Tech Computer Science", ProgramType.PG, mtechCsCurriculum);
        csDept.addProgram(btechCS);
        csDept.addProgram(mtechCS);

        Qualification q1 = new Qualification("High School", 92.5, "DPS", 2022, QualificationType.HIGH_SCHOOL);
        Student s1 = new Student("S101", "Alice", q1); 
        
        Qualification q2 = new Qualification("High School", 88.0, "KVS", 2022, QualificationType.HIGH_SCHOOL);
        Student s2 = new Student("S102", "Bob", q2); 

        Qualification q3 = new Qualification("B.Tech", 8.5, "NIT", 2023, QualificationType.BACHELORS, true, 75.0); 
        Student s3 = new Student("S103", "Charlie", q3); 

        Qualification q4 = new Qualification("B.Tech", 9.2, "IIT", 2023, QualificationType.BACHELORS, false, 0.0); 
        Student s4 = new Student("S104", "David", q4); 

        AdmissionProcess btechAdmission2024 = new AdmissionProcess(2024, btechCS, csDept, 1, new StandardMeritCalculator());
        AdmissionProcess mtechAdmission2024 = new AdmissionProcess(2024, mtechCS, csDept, 1, new GatePreferenceMeritCalculator());

        btechAdmission2024.apply(s1);
        btechAdmission2024.apply(s2);

        mtechAdmission2024.apply(s3);
        mtechAdmission2024.apply(s4);

        btechAdmission2024.generateMeritListAndAdmit();
        btechAdmission2024.printAdmittedStudents();
        
        System.out.println();
        
        mtechAdmission2024.generateMeritListAndAdmit();
        mtechAdmission2024.printAdmittedStudents();
    }
}

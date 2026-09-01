import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generalized Student Admission & Program Registration System ===");

        Department scsitDept = new Department("School of Computer Science & IT (DAVV)");

        Curriculum bcaCurriculum = new Curriculum(6, 120, Arrays.asList("Programming in C", "Database Management", "Web Technologies"));
        Curriculum mcaCurriculum = new Curriculum(4, 80, Arrays.asList("Advanced Java", "Cloud Computing", "Software Engineering"));
        Curriculum mtechCsCurriculum = new Curriculum(4, 80, Arrays.asList("Advanced ML", "Distributed Systems", "Cloud Computing"));
        Curriculum mtechNmisCurriculum = new Curriculum(4, 80, Arrays.asList("Cryptography", "Network Security", "Ethical Hacking"));
        Curriculum mtechIaseCurriculum = new Curriculum(4, 80, Arrays.asList("Software Architecture", "Information Systems", "Agile Methodologies"));
        Curriculum integratedMcaCurriculum = new Curriculum(10, 200, Arrays.asList("Fundamentals of IT", "Advanced Data Structures", "AI"));

        Program bca = new Program("BCA", ProgramType.UG, bcaCurriculum);
        Program mca = new Program("MCA", ProgramType.PG, mcaCurriculum);
        Program mtechCS = new Program("M.Tech Computer Science", ProgramType.PG, mtechCsCurriculum);
        Program mtechNMIS = new Program("M.Tech Network Management & Information Security", ProgramType.PG, mtechNmisCurriculum);
        Program mtechIASE = new Program("M.Tech Information Architecture & Software Engineering", ProgramType.PG, mtechIaseCurriculum);
        Program intMCA = new Program("Integrated MCA (BCA + MCA)", ProgramType.UG, integratedMcaCurriculum);

        scsitDept.addProgram(bca);
        scsitDept.addProgram(mca);
        scsitDept.addProgram(mtechCS);
        scsitDept.addProgram(mtechNMIS);
        scsitDept.addProgram(mtechIASE);
        scsitDept.addProgram(intMCA);

        Qualification q1 = new Qualification("High School", 92.5, "DPS", 2023, QualificationType.HIGH_SCHOOL);
        Student s1 = new Student("S101", "Alice", q1);

        Qualification q2 = new Qualification("High School", 88.0, "KVS", 2023, QualificationType.HIGH_SCHOOL);
        Student s2 = new Student("S102", "Bob", q2);

        Qualification q3 = new Qualification("BCA", 8.5, "DAVV", 2023, QualificationType.BACHELORS, false, 0.0);
        Student s3 = new Student("S103", "Charlie", q3);

        Qualification q4 = new Qualification("B.Tech", 9.2, "IIT", 2023, QualificationType.BACHELORS, true, 75.0);
        Student s4 = new Student("S104", "David", q4);

        Qualification q5 = new Qualification("B.Tech", 7.8, "NIT", 2023, QualificationType.BACHELORS, false, 0.0);
        Student s5 = new Student("S105", "Eve", q5);

        AdmissionProcess bcaAdmission = new AdmissionProcess(2024, bca, scsitDept, 1, new StandardMeritCalculator());
        AdmissionProcess intMcaAdmission = new AdmissionProcess(2024, intMCA, scsitDept, 1, new StandardMeritCalculator());
        AdmissionProcess mcaAdmission = new AdmissionProcess(2024, mca, scsitDept, 1, new StandardMeritCalculator());
        AdmissionProcess mtechCsAdmission = new AdmissionProcess(2024, mtechCS, scsitDept, 1, new GatePreferenceMeritCalculator());
        AdmissionProcess mtechNmisAdmission = new AdmissionProcess(2024, mtechNMIS, scsitDept, 1, new GatePreferenceMeritCalculator());

        bcaAdmission.apply(s1);
        intMcaAdmission.apply(s2);
        mcaAdmission.apply(s3);
        mtechCsAdmission.apply(s4);
        mtechNmisAdmission.apply(s5);

        bcaAdmission.generateMeritListAndAdmit();
        bcaAdmission.printAdmittedStudents();
        System.out.println();

        intMcaAdmission.generateMeritListAndAdmit();
        intMcaAdmission.printAdmittedStudents();
        System.out.println();

        mcaAdmission.generateMeritListAndAdmit();
        mcaAdmission.printAdmittedStudents();
        System.out.println();

        mtechCsAdmission.generateMeritListAndAdmit();
        mtechCsAdmission.printAdmittedStudents();
        System.out.println();

        mtechNmisAdmission.generateMeritListAndAdmit();
        mtechNmisAdmission.printAdmittedStudents();
    }
}

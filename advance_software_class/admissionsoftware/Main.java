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

        EligibilityChecker ugEligibility = new BasicEligibilityChecker(QualificationType.HIGH_SCHOOL, 50.0);
        EligibilityChecker pgEligibility = new BasicEligibilityChecker(QualificationType.BACHELORS, 60.0);

        Program bca = new Program("BCA", ProgramType.UG, bcaCurriculum, ugEligibility);
        Program mca = new Program("MCA", ProgramType.PG, mcaCurriculum, pgEligibility);
        Program mtechCS = new Program("M.Tech Computer Science", ProgramType.PG, mtechCsCurriculum, pgEligibility);
        Program mtechNMIS = new Program("M.Tech Network Management & Information Security", ProgramType.PG, mtechNmisCurriculum, pgEligibility);
        Program mtechIASE = new Program("M.Tech Information Architecture & Software Engineering", ProgramType.PG, mtechIaseCurriculum, pgEligibility);
        Program intMCA = new Program("Integrated MCA (BCA + MCA)", ProgramType.UG, integratedMcaCurriculum, ugEligibility);

        scsitDept.addProgram(bca);
        scsitDept.addProgram(mca);
        scsitDept.addProgram(mtechCS);
        scsitDept.addProgram(mtechNMIS);
        scsitDept.addProgram(mtechIASE);
        scsitDept.addProgram(intMCA);

        Student s1 = new Student("S101", "Alice");
        s1.addQualification(new Qualification("High School", 92.5, "DPS", 2023, QualificationType.HIGH_SCHOOL));
        
        Student s2 = new Student("S102", "Bob");
        s2.addQualification(new Qualification("High School", 48.0, "KVS", 2023, QualificationType.HIGH_SCHOOL)); // Should be rejected ( < 50% )

        Student s3 = new Student("S103", "Charlie");
        s3.addQualification(new Qualification("High School", 85.0, "State Board", 2020, QualificationType.HIGH_SCHOOL));
        s3.addQualification(new Qualification("BCA", 8.5, "DAVV", 2023, QualificationType.BACHELORS, false, 0.0));

        Student s4 = new Student("S104", "David");
        s4.addQualification(new Qualification("High School", 90.0, "CBSE", 2019, QualificationType.HIGH_SCHOOL));
        s4.addQualification(new Qualification("B.Tech", 9.2, "IIT", 2023, QualificationType.BACHELORS, false, 0.0));
        s4.addQualification(new Qualification("GATE", 75.0, "GATE Board", 2023, QualificationType.GATE, true, 75.0));

        Student s5 = new Student("S105", "Eve");
        s5.addQualification(new Qualification("High School", 88.0, "CBSE", 2019, QualificationType.HIGH_SCHOOL));
        s5.addQualification(new Qualification("B.Tech", 7.8, "NIT", 2023, QualificationType.BACHELORS, false, 0.0));

        Student s6 = new Student("S106", "Frank"); // Has GATE but no Bachelors
        s6.addQualification(new Qualification("High School", 80.0, "CBSE", 2019, QualificationType.HIGH_SCHOOL));
        s6.addQualification(new Qualification("GATE", 65.0, "GATE Board", 2023, QualificationType.GATE, true, 65.0));

        AdmissionProcess bcaAdmission = new AdmissionProcess(2024, bca, scsitDept, 1, new StandardMeritCalculator(QualificationType.HIGH_SCHOOL));
        AdmissionProcess intMcaAdmission = new AdmissionProcess(2024, intMCA, scsitDept, 1, new StandardMeritCalculator(QualificationType.HIGH_SCHOOL));
        AdmissionProcess mcaAdmission = new AdmissionProcess(2024, mca, scsitDept, 1, new StandardMeritCalculator(QualificationType.BACHELORS));
        AdmissionProcess mtechCsAdmission = new AdmissionProcess(2024, mtechCS, scsitDept, 2, new GatePreferenceMeritCalculator());
        AdmissionProcess mtechNmisAdmission = new AdmissionProcess(2024, mtechNMIS, scsitDept, 1, new GatePreferenceMeritCalculator());

        System.out.println("\n--- Applying to Programs ---");
        bcaAdmission.apply(s1);
        intMcaAdmission.apply(s2);
        mcaAdmission.apply(s3);
        mtechCsAdmission.apply(s4);
        mtechCsAdmission.apply(s5);
        mtechCsAdmission.apply(s6);
        mtechNmisAdmission.apply(s5);

        System.out.println("\n--- Generating Merit Lists & Admissions ---");
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

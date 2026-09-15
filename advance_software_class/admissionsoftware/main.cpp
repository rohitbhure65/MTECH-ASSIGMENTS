#include <iostream>
#include <memory>
#include <vector>
#include <string>
#include "Qualification.h"
#include "Student.h"
#include "EligibilityChecker.h"
#include "ScoreNormalizer.h"
#include "IndianCGPANormalizer.h"
#include "PassThroughNormalizer.h"
#include "BasicEligibilityChecker.h"
#include "Curriculum.h"
#include "Program.h"
#include "Department.h"
#include "MeritCalculator.h"
#include "StandardMeritCalculator.h"
#include "GatePreferenceMeritCalculator.h"
#include "AdmissionProcess.h"

using namespace std;

int main() {
    cout << "=== Generalized Student Admission & Program Registration System ===" << endl;

    auto scsitDept = make_shared<Department>("School of Computer Science & IT (DAVV)");

    auto bcaCurriculum = make_shared<Curriculum>(6, 120, vector<string>{"Programming in C", "Database Management", "Web Technologies"});
    auto mcaCurriculum = make_shared<Curriculum>(4, 80, vector<string>{"Advanced Java", "Cloud Computing", "Software Engineering"});
    auto mtechCsCurriculum = make_shared<Curriculum>(4, 80, vector<string>{"Advanced ML", "Distributed Systems", "Cloud Computing"});
    auto mtechNmisCurriculum = make_shared<Curriculum>(4, 80, vector<string>{"Cryptography", "Network Security", "Ethical Hacking"});
    auto mtechIaseCurriculum = make_shared<Curriculum>(4, 80, vector<string>{"Software Architecture", "Information Systems", "Agile Methodologies"});
    auto integratedMcaCurriculum = make_shared<Curriculum>(10, 200, vector<string>{"Fundamentals of IT", "Advanced Data Structures", "AI"});

    auto indianNormalizer = make_shared<IndianCGPANormalizer>();

    auto ugEligibility = make_shared<BasicEligibilityChecker>("HIGH_SCHOOL", 50.0, indianNormalizer);
    auto pgEligibility = make_shared<BasicEligibilityChecker>("BACHELORS", 60.0, indianNormalizer);

    auto bca = make_shared<Program>("BCA", "UG", bcaCurriculum, ugEligibility);
    auto mca = make_shared<Program>("MCA", "PG", mcaCurriculum, pgEligibility);
    auto mtechCS = make_shared<Program>("M.Tech Computer Science", "PG", mtechCsCurriculum, pgEligibility);
    auto mtechNMIS = make_shared<Program>("M.Tech Network Management & Information Security", "PG", mtechNmisCurriculum, pgEligibility);
    auto mtechIASE = make_shared<Program>("M.Tech Information Architecture & Software Engineering", "PG", mtechIaseCurriculum, pgEligibility);
    auto intMCA = make_shared<Program>("Integrated MCA (BCA + MCA)", "UG", integratedMcaCurriculum, ugEligibility);

    scsitDept->addProgram(bca);
    scsitDept->addProgram(mca);
    scsitDept->addProgram(mtechCS);
    scsitDept->addProgram(mtechNMIS);
    scsitDept->addProgram(mtechIASE);
    scsitDept->addProgram(intMCA);

    Student s1("S101", "Alice");
    s1.addQualification(Qualification("High School", 92.5, "DPS", 2023, "HIGH_SCHOOL"));
    
    Student s2("S102", "Bob");
    s2.addQualification(Qualification("High School", 48.0, "KVS", 2023, "HIGH_SCHOOL"));

    Student s3("S103", "Charlie");
    s3.addQualification(Qualification("High School", 85.0, "State Board", 2020, "HIGH_SCHOOL"));
    s3.addQualification(Qualification("BCA", 8.5, "DAVV", 2023, "BACHELORS"));

    Student s4("S104", "David");
    s4.addQualification(Qualification("High School", 90.0, "CBSE", 2019, "HIGH_SCHOOL"));
    s4.addQualification(Qualification("B.Tech", 9.2, "IIT", 2023, "BACHELORS"));
    s4.addQualification(Qualification("GATE", 75.0, "GATE Board", 2023, "GATE", true, 75.0));

    Student s5("S105", "Eve");
    s5.addQualification(Qualification("High School", 88.0, "CBSE", 2019, "HIGH_SCHOOL"));
    s5.addQualification(Qualification("B.Tech", 7.8, "NIT", 2023, "BACHELORS"));

    Student s6("S106", "Frank");
    s6.addQualification(Qualification("High School", 80.0, "CBSE", 2019, "HIGH_SCHOOL"));
    s6.addQualification(Qualification("GATE", 65.0, "GATE Board", 2023, "GATE", true, 65.0));

    AdmissionProcess bcaAdmission(2024, bca, scsitDept, 1, make_shared<StandardMeritCalculator>("HIGH_SCHOOL", indianNormalizer));
    AdmissionProcess intMcaAdmission(2024, intMCA, scsitDept, 1, make_shared<StandardMeritCalculator>("HIGH_SCHOOL", indianNormalizer));
    AdmissionProcess mcaAdmission(2024, mca, scsitDept, 1, make_shared<StandardMeritCalculator>("BACHELORS", indianNormalizer));
    AdmissionProcess mtechCsAdmission(2024, mtechCS, scsitDept, 2, make_shared<GatePreferenceMeritCalculator>(indianNormalizer));
    AdmissionProcess mtechNmisAdmission(2024, mtechNMIS, scsitDept, 1, make_shared<GatePreferenceMeritCalculator>(indianNormalizer));

    cout << "\n--- Applying to Programs ---" << endl;
    bcaAdmission.apply(s1);
    intMcaAdmission.apply(s2);
    mcaAdmission.apply(s3);
    mtechCsAdmission.apply(s4);
    mtechCsAdmission.apply(s5);
    mtechCsAdmission.apply(s6);
    mtechNmisAdmission.apply(s5);

    cout << "\n--- Generating Merit Lists & Admissions ---" << endl;
    bcaAdmission.generateMeritListAndAdmit();
    bcaAdmission.printAdmittedStudents();
    cout << endl;

    intMcaAdmission.generateMeritListAndAdmit();
    intMcaAdmission.printAdmittedStudents();
    cout << endl;

    mcaAdmission.generateMeritListAndAdmit();
    mcaAdmission.printAdmittedStudents();
    cout << endl;

    mtechCsAdmission.generateMeritListAndAdmit();
    mtechCsAdmission.printAdmittedStudents();
    cout << endl;

    mtechNmisAdmission.generateMeritListAndAdmit();
    mtechNmisAdmission.printAdmittedStudents();

    return 0;
}
